package gilded.rose.refactoring.kata.solution;


import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterUtils.isQualityStrictlyPositive;
import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterUtils.isSellInNegative;

/**
 * @author amihai
 */
public class DefaultItemQualityUpdater implements ItemQualityUpdater{

	@Override
	public void update(Item item) {

		if (isQualityStrictlyPositive(item)) {
			item.quality -= 1;
		}

		item.sellIn -= 1;

		if (isSellInNegative(item) && isQualityStrictlyPositive(item)) {
			item.quality -= 1;
		}

	}
}
