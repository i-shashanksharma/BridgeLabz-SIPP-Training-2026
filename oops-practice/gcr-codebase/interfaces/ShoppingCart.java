interface CouponValidator {
    boolean validateCoupon(String code);
    static boolean isLengthValid(String code) {
        return code.length() >= 5;
    }
}

class ShoppingCart implements CouponValidator {

    public boolean validateCoupon(String code) {
        return CouponValidator.isLengthValid(code) && code.startsWith("SAVE");
    }

    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "ABC12",
                "SAVE50",
                "OFF",
                "SAVE100"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon))
                System.out.println(coupon + " : Valid");
            else
                System.out.println(coupon + " : Invalid");
        }
    }
}