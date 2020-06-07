package gilded.rose.refactoring.kata.solution;

import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterFactory.AGED_BRIE;
import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterFactory.SULFURAS_HAND_OF_RAGNAROS;
import static gilded.rose.refactoring.kata.solution.ItemQualityUpdaterFactory.TAFKAL_80_ETC_CONCERT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class GildedRoseTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void givenItemNameNotInPredefinedOnesAndQualityGreaterThan0AndSellinGreaterThan0ThenItemQualityDecrements(int quality) {

		//given
		Item itemToBeUpdated = new Item("foo", 10, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);

		// verify
		app.updateQuality();
		assertEquals(quality - 1, itemToBeUpdated.quality);
	}



	@ParameterizedTest
	@MethodSource("qualityPositiveAndSellinLessThan50")
	void givenItemNameAgedBrieAndQualityLessThan50SellinBiggerThen0ThenItemQualityIncreases(int quality, int sellIn) {

		// given
		Item itemToBeUpdated = new Item(AGED_BRIE, sellIn, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 1, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("qualityLessThen50AndSellInBiggerThan11")
	void givenItemNameTafkalAndQualityLessThen50AndSellInBiggerThen11ThenItemQualityIncreasesByOne(int quality, int selling) {
		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, selling, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 1, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("quality49andSellInLessThen11")
	void givenItemNameTafkalAndQualityLessThen50AndSellInLessThan11ThenItemQualityIncreasesByOne(int quality, int selling) {

		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, selling, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 1, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("qualityLessThan49andSellInBetween6and11")
	void givenItemNameTafkalAndQuality49AndSellingBetween6And11ThenItemQualityIncreasesByTwo(int quality, int selling) {

		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, selling, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 2, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("quality48andSellInLessThen6")
	void givenItemNameTafkalAndQuality48AndSellInLessThen6ThenItemQualityIncreasesByTwo(int quality, int selling) {

		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, selling, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 2, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("qualityLessThen48AndSellInLessThen6")
	void givenItemNameTafkalAndQualityBiggerThan48AndSellingLowerThen6ItemQualityIncreasesByThree() {

		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, 5, 12);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(15, itemToBeUpdated.quality);
	}

	// --------- tests for negative selling

	@Test
	void givenNonPredefinedItemNameAndSellInIsNegativeAndItemQualityIs1WhenUpdateQualityThenQualityDecreasesByOne() {
		// given
		Item itemToBeUpdated = new Item("some random item name", -1, 1);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(0, itemToBeUpdated.quality);
	}

	@Test
	void givenNonPredefinedItemNameAndSellInIsNegativeAndQualityIsBiggerThan1WhenUpdateQualityThenQualityDecreasedByTwo() {

		// given
		Item itemToBeUpdated = new Item("some random item name", -1, 2);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(0, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@MethodSource("sellInNegativeAndQualityRandom")
	void givenTafkalConcertItemAndSellingNegativeWhenUpdateQualityThenQualityIsZero(int quality, int sellIn) {

		// given
		Item itemToBeUpdated = new Item(TAFKAL_80_ETC_CONCERT, sellIn, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(0, itemToBeUpdated.quality);
	}

	@Test
	void givenAgedBriedItemAndSellInNegativeAndQuality49WhenUpdateQualityThenQualityIncreaseByOne() {
		// given
		Item itemToBeUpdated = new Item(AGED_BRIE, -1, 49);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(50, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 37, 48})
	void givenAgedBriedItemAndSellInNegativeAndQualityLessThen49WhenUpdateQualityThenQualityIncreaseByTwo(int quality) {

		// given
		Item itemToBeUpdated = new Item(AGED_BRIE, -1, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(quality + 2, itemToBeUpdated.quality);
	}

	// ----------- specific tests for sulfuras item name

	@Test
	void givenRandomItemDifferentFromSulfurasWhenUpdateQualityThenSellInDecreasedByOne() {


		// given
		Item itemToBeUpdated = new Item("not sulfuras", 2, 1);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// verify
		assertEquals(1, itemToBeUpdated.sellIn);
	}


	@ParameterizedTest
	@MethodSource("sellingAndQualityPositive")
	void givenItemNameSulfurasAndQualityBiggerThen0AndSellInPositiveThenValuesUnchanged(int quality, int selling) {

		//given
		Item itemToBeUpdated = new Item(SULFURAS_HAND_OF_RAGNAROS, selling, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);

		// verify
		app.updateQuality();
		assertEquals(quality, itemToBeUpdated.quality);
		assertEquals(selling, itemToBeUpdated.sellIn);
	}

	@Test
	void givenRandomItemNameAndSellInNegativeAndQualityIsOneWhenUpdateQualityThenQualityDecreasedByOne() {

		//given
		Item itemToBeUpdated = new Item("random", -1, 1);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);

		// verify
		app.updateQuality();
		assertEquals(-2, itemToBeUpdated.sellIn);
		assertEquals(0, itemToBeUpdated.quality);
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4, 5, 6, 7})
	void givenRandomItemNameAndSellInNegativeAndQualityBiggerThanOneWhenUpdateQualityThenQualityDecresesByTwo(int quality) {

		//given
		Item itemToBeUpdated = new Item("random", -1, quality);
		Item[] items = new Item[]{itemToBeUpdated};

		// execute
		GildedRose app = new GildedRose(items);

		// verify
		app.updateQuality();
		assertEquals(-2, itemToBeUpdated.sellIn);
		assertEquals(quality - 2, itemToBeUpdated.quality);
	}


	private static Stream<Arguments> sellingAndQualityPositive() {
		return Stream.of(
				Arguments.of(1, 1),
				Arguments.of(2, 2),
				Arguments.of(12, 15),
				Arguments.of(22, 100)
		);
	}

	private static Stream<Arguments> qualityPositiveAndSellinLessThan50() {
		return Stream.of(
				Arguments.of(1, 3),
				Arguments.of(3, 3),
				Arguments.of(5, 10),
				Arguments.of(49, 49),
				Arguments.of(49, 49)
		);
	}

	private static Stream<Arguments> qualityLessThen50AndSellInBiggerThan11() {
		return Stream.of(
				Arguments.of(29, 12),
				Arguments.of(39, 13),
				Arguments.of(40, 14),
				Arguments.of(48, 22),
				Arguments.of(49, 49)
		);
	}

	private static Stream<Arguments> quality49andSellInLessThen11() {
		return Stream.of(
				Arguments.of(49, 10),
				Arguments.of(49, 9),
				Arguments.of(49, 8),
				Arguments.of(49, 7),
				Arguments.of(49, 6),
				Arguments.of(49, 5),
				Arguments.of(49, 4),
				Arguments.of(49, 3),
				Arguments.of(49, 2),
				Arguments.of(49, 1)
		);
	}


	private static Stream<Arguments> qualityLessThan49andSellInBetween6and11() {
		return Stream.of(
				Arguments.of(3, 6),
				Arguments.of(3, 7),
				Arguments.of(10, 8),
				Arguments.of(48, 9),
				Arguments.of(48, 10)
		);
	}

	private static Stream<Arguments> quality48andSellInLessThen6() {
		return Stream.of(
				Arguments.of(48, 1),
				Arguments.of(48, 2),
				Arguments.of(48, 3),
				Arguments.of(48, 4),
				Arguments.of(48, 5)
		);
	}

	private static Stream<Arguments> qualityLessThen48AndSellInLessThen6() {
		return Stream.of(
				Arguments.of(3, 1),
				Arguments.of(3, 2),
				Arguments.of(10, 3),
				Arguments.of(46, 4),
				Arguments.of(47, 5)
		);
	}

	private static Stream<Arguments> sellInNegativeAndQualityRandom() {
		return Stream.of(
				Arguments.of(12, -1),
				Arguments.of(1, -2),
				Arguments.of(2, -3),
				Arguments.of(3, -3),
				Arguments.of(4, -19),
				Arguments.of(5, -13),
				Arguments.of(12, -3),
				Arguments.of(9, -3),
				Arguments.of(-1, -3)
		);
	}

}
