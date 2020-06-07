package gilded.rose.refactoring.kata.solution;

import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterUtils.isQualityLessThanHalf;
import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterUtils.isSellInNegative;

/**
 * @author amihai
 */
public class AgedBrieItemQualityUpdater implements ItemQualityUpdater {

	@Override
	public void update(Item item) {

		if (isQualityLessThanHalf(item)) {
			item.quality += 1;
		}

		item.sellIn -= 1;

		if (isSellInNegative(item) && isQualityLessThanHalf(item)) {
			item.quality += 1;
		}
	}

}
