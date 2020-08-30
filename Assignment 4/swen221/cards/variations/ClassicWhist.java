package swen221.cards.variations;

import java.util.List;

import swen221.cards.core.Card;
import swen221.cards.core.Player;
import swen221.cards.util.AbstractCardGame;

/**
 * An implementation of the "classical" rules of Whist.
 *
 * @author David J. Pearce
 *
 */
public class ClassicWhist extends AbstractCardGame {

	public ClassicWhist() {

	}

	@Override
	public String getName() {
		return "Classic Whist";
	}

	@Override
	public boolean isGameFinished() {
		for (Player.Direction d : Player.Direction.values()) {
			if (scores.get(d) == 5) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deal(List<Card> deck) {
		currentTrick = null;
		for (Player.Direction d : Player.Direction.values()) {
			players.get(d).getHand().clear();
		}
		Player.Direction d = Player.Direction.NORTH;
		for (int i = 0; i < deck.size(); ++i) {
			Card card = deck.get(i);
			players.get(d).getHand().add(card);
			d = d.next();
		}
	}
}
