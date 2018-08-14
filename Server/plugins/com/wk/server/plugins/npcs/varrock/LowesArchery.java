package com.wk.server.plugins.npcs.varrock;

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

public final class LowesArchery implements ShopInterface,
		TalkToNpcExecutiveListener, TalkToNpcListener {

	private final Shop shop = new Shop(false, 3000, 100, 55, 1, new Item(11,
			200), new Item(190, 150), new Item(189, 4), new Item(
			188, 2), new Item(60, 2));

	@Override
	public boolean blockTalkToNpc(final Player p, final Npc n) {
		return n.getID() == 58;
	}

	@Override
	public Shop[] getShops() {
		return new Shop[] { shop };
	}

	@Override
	public boolean isMembers() {
		return false;
	}

	@Override
	public void onTalkToNpc(final Player p, final Npc n) {
		npcTalk(p, n, "Welcome to Lowe's Archery Store",
				"Do you want to see my wares?");

		int option = showMenu(p, n, "Yes please",
				"No, I prefer to bash things close up");

		if (option == 0) {
			p.setAccessingShop(shop);
			ActionSender.showShop(p, shop);
		}
	}

}
