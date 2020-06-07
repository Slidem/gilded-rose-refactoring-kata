package gilded.rose.refactoring.kata.solution;

import static java.util.Objects.requireNonNull;

/**
 * @author amihai
 */
public class ItemQualityUpdaterFactory {

	public static final String AGED_BRIE = "Aged Brie";
	public static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

	private NoopItemQualityUpdater noopItemQualityUpdater = new NoopItemQualityUpdater();

	private DefaultItemQualityUpdater defaultItemQualityUpdater = new DefaultItemQualityUpdater();

	private TafkalItemQualityUpdater tafkalItemQualityUpdater = new TafkalItemQualityUpdater();

	private AgedBrieItemQualityUpdater agedBrieItemQualityUpdater = new AgedBrieItemQualityUpdater();

	ItemQualityUpdater get(Item item) {

		requireNonNull(item, "Cannot create ItemQualityUpdater from null instance");
		requireNonNull(item.name, "Cannot create ItemQualityUpdater from item with null name");

		switch (item.name) {
			case TAFKAL_80_ETC_CONCERT:
				return tafkalItemQualityUpdater;
			case AGED_BRIE:
				return agedBrieItemQualityUpdater;
			case SULFURAS_HAND_OF_RAGNAROS:
				return noopItemQualityUpdater;
			default:
				return defaultItemQualityUpdater;
		}
	}

}
