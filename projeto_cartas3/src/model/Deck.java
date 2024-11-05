package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Carta> deck = new ArrayList<Carta>();
	public void addCard(Carta carta) {
		deck.add(carta);
	}
	public int size(){
		return this.deck.size();
	}
	public Carta getCarta(int i){
		return this.deck.get(i);
	}
}

