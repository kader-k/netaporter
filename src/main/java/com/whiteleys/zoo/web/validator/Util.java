package com.whiteleys.zoo.web.validator;

public class Util {
	public static boolean isPostcodeValid(String postcode) {
		return validateUKPostcode(postcode) == null ? false : true;
	}
	
	public static String validateUKPostcode(String postcode) {

		if (postcode == null || postcode.trim().length() <= 0) {
			return null;
		}
		
		postcode = postcode.toUpperCase();
		postcode = postcode.replace("\\s+", "");

		// NB: regexp taken from
		// http://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom and
		// tweaked to not need spaces (as they're stripped out)
		boolean match = postcode.matches("(GIR0AA)|(((A[BL]|B[ABDFHLNRSTX]?|C[ABFHMORTVW]|D[ADEGHLNTY]|E[HNX]?|F[KY]|G[LUY]?|H[ADGPRSUX]|I[GMPV]|JE|K[ATWY]|L[ADELNSU]?|M[EKL]?|N[EGNPRW]?|O[LX]|P[AEHLOR]|R[GHM]|S[AEGKLMNOPRSTY]?|T[ADFNQRSW]|UB|W[ADFNRSV]|YO|ZE)[1-9]?[0-9]|((E|N|NW|SE|SW|W)1|EC[1-4]|WC[12])[A-HJKMNPR-Y]|(SW|W)([2-9]|[1-9][0-9])|EC[1-9][0-9]) {0,1}[0-9][ABD-HJLNP-UW-Z]{2})");

		if (match) {
			int splitPoint = postcode.length() - 3;
			return postcode.substring(0, splitPoint) + " "
					+ postcode.substring(splitPoint);
		}
		return null;
	}
}
