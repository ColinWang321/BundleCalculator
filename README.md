# BundleCalculator
Calculate best bundles


This is a Bundle Calculator. Trying to calculate the best bundles for mission like bellow:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## How to use it
When you download the project, you need to build a new Bundle class, then use the 'bestBundle(int number, String type)' function.

Type should be one of the above "IMG", "FLAC", or "VID".

This function will return the result as a string.

Sample is below:

	public static void main(String[] args) {

		Bundle bundle = new Bundle();

		String str = bundle.bestBundle(26, "IMG");
		logger.info(str);


	}

