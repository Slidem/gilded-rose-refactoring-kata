package gilded.rose.refactoring.kata.solution;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TexttestFixture {
	public static void main(String[] args) throws IOException {
		System.out.println("OMGHAI!");

		Item[] items = new Item[]{
				new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6)};

		GildedRose app = new GildedRose(items);

		int days = 10;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		String textFixturesOutputFile = "text-fixtures-v0.txt";

		if (Files.exists(Paths.get(textFixturesOutputFile))) {
			textFixturesOutputFile = incrementFileNameVersion(textFixturesOutputFile);
		}

		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(textFixturesOutputFile))) {

			for (int i = 0; i < days; i++) {
				bw.write("-------- day " + i + " --------\n");
				bw.write("name, sellIn, quality\n");
				for (Item item : items) {
					bw.write(item.toString() + "\n");
				}
				bw.write("\n");
				app.updateQuality();
			}
		}

	}

	private static String incrementFileNameVersion(String textFixturesOutput) {
		int versionIndex = textFixturesOutput.indexOf("-v");

		String currentVersion = "";

		for (int i = versionIndex + 2; i < textFixturesOutput.length(); i++) {
			char c = textFixturesOutput.charAt(i);
			try {
				Integer.parseInt(String.valueOf(c));
			} catch (NumberFormatException e) {
				break;
			}
			currentVersion += c;
		}

		int nextVersion = Integer.parseInt(currentVersion) + 1;
		return textFixturesOutput.replaceFirst("-v" + currentVersion, "-v" + nextVersion);
	}
}
