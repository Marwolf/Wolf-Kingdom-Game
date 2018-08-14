package com.wk.server.plugins.npcs.ardougne.east;

import static com.wk.server.plugins.Functions.npcTalk;
import static com.wk.server.plugins.Functions.showMenu;

import com.wk.server.model.Shop;
import com.wk.server.model.container.Item;
import com.wk.server.model.entity.npc.Npc;
import com.wk.server.model.entity.player.Player;
import com.wk.server.net.rsc.ActionSender;
import com.wk.server.plugins.ShopInterface;
import com.wk.server.plugins.listeners.action.TalkToNpcListener;
import com.wk.server.plugins.listeners.executive.TalkToNpcExecutiveListener;

public class Zenesha implements ShopInterface, TalkToNpcExecutiveListener, TalkToNpcListener {

	private final Shop shop = new Shop(false, 30000, 100, 60, 2, new Item(308, 3), new Item(312, 1), new Item(309, 1), new Item(313, 1), new Item(310, 1));

	@Override
	public void onTalkToNpc(Player p, Npc n) {
		
			npcTalk(p, n, "hello I sell plate mail tops");
			int menu = showMenu(p, n, "I'm not interested", "I may be interested");
			if(menu == 1) {
				npcTalk(p, n, "Look at these fine samples then");
				p.setAccessingShop(shop);
				ActionSender.showShop(p, shop);
			} 
	}

	@Override
	public boolean blockTalkToNpc(Player p, Npc n) {
		return n.getID() == 331;
	}

	@Override
	public Shop[] getShops() {
		return new Shop[] { shop };
	}

	@Override
	public boolean isMembers() {
		return true;
	}
}
