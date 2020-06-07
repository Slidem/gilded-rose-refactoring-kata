package gilded.rose.refactoring.kata.solution;

class GildedRose {

	Item[] items;

	private ItemQualityUpdaterFactory itemQualityUpdaterFactory;


	public GildedRose(Item[] items) {
		this.items = items;
		this.itemQualityUpdaterFactory = new ItemQualityUpdaterFactory();
	}

	public GildedRose(Item[] items, ItemQualityUpdaterFactory itemQualityUpdaterFactory) {
		this.items = items;
		this.itemQualityUpdaterFactory = itemQualityUpdaterFactory;
	}

	public void updateQuality() {

		for (Item item : items) {
			itemQualityUpdaterFactory.get(item).update(item);
		}
	}

}