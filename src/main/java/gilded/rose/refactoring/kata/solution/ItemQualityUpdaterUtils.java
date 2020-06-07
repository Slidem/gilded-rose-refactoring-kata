package gilded.rose.refactoring.kata.solution;

/**
 * @author amihai
 */
final class ItemQualityUpdaterUtils {

	private ItemQualityUpdaterUtils() {
	}


	static boolean isSellInNegative(Item item) {
		return item.sellIn < 0;
	}

	static boolean isQualityStrictlyPositive(Item item) {
		return item.quality > 0;
	}

	static boolean isQualityLessThanHalf(Item item) {
		return item.quality < 50;
	}
}
