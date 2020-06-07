package gilded.rose.refactoring.kata.solution;

/**
 * @author amihai
 */
public class NoopItemQualityUpdater implements ItemQualityUpdater {

	@Override
	public void update(Item item) {
		// no operation needed here
	}

}
