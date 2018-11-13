package com.jd.apply

/**
 *
 * <p>2018/11/13 17:26</p>
 * @author wangyingjie1
 * @since V1.0
 */
class MQOrderConverterImpl {


    private XmlSlurper parser = new XmlSlurper();

    String convert(String mqText){

        String[] ordercart = mqText.split("8e5220aa_bbc2_4eb9_b849_a4afd76bc6e3");
        def order = parser.parseText(ordercart[0]);

        int num = 0;

        def cart = parser.parseText(ordercart[1]);

        cart.TheSkus.SKU.each{x -> num = num + Integer.parseInt(x.Num.text())};

        cart.TheGifts.Suit.MainSKU.each{x -> num = num + Integer.parseInt(x.Num.text())};

        cart.TheGifts.Suit.TheSkus.SKU.each{x -> num = num + Integer.parseInt(x.Num.text())};

        cart.ThePacks.Suit.TheSkus.SKU.each{x -> num = num + Integer.parseInt(x.Num.text())};

        cart.ThePacks.Suit.Gifts.SKU.each{x -> num = num + Integer.parseInt(x.Num.text())};

        double jingDouDiscount = 0;

        if(order.JingDouCount.text() != null && !order.JingDouCount.text().equals("")){
            jingDouDiscount = Double.parseDouble(order.JingDouCount.text()) / Double.parseDouble(order.JingDouRate.text());
        }

        double factPrice =  Double.parseDouble(order.Price.text()) - Double.parseDouble(order.RePrice.text()) - Double.parseDouble(order.Discount.text()) + Double.parseDouble(order.TotalFee.text()) - Double.parseDouble(order.ElePowDiscount.text() == null || order.ElePowDiscount.text() == "" ? "0" : order.ElePowDiscount.text()) -

                Double.parseDouble(order.CouponDiscount.text()) - Double.parseDouble(order.DiscountTelecomIntegral.text() == null || order.DiscountTelecomIntegral.text() == "" ? "0" : order.DiscountTelecomIntegral.text() ) - Double.parseDouble(order.MoneyBalance.text()) - Double.parseDouble(order.DiscountLipinka.text()) -

                Double.parseDouble(order.DiscountMobile.text() == null || order.DiscountMobile.text() == "" ? "0" : order.DiscountMobile.text()) - Double.parseDouble(order.JiFenDiscountMoney.text()) - jingDouDiscount;

        String score = order.UseScore.text();

        if( score == null || score.equals("") ){
            score = "0";
        }

        String jingDouCount = order.JingDouCount.text();
        if( jingDouCount == null || jingDouCount.equals("") ){
            jingDouCount = "0";
        }
        String jingDouRate = order.JingDouRate.text();
        if( jingDouRate == null || jingDouRate.equals("") ){
            jingDouRate = "0";
        }

        String coupons = "\"coupons\":[";
        String coupon = "{}";
        order.TheCoupons.Coupon.each{x -> coupon = coupon + "," + "{\"couponType\":" + x.CouponType + ",\"discount\":" + x.Discount + ",\"id\":\"" + x.Id + "\"}"};

        coupon = coupon.replace("{},", "");

        coupons = coupons + coupon + "]";

        String result = "{\"OrderId\":"+order.OrderId.text()+",\"MessageType\":0,\"UseBalance\":"+order.MoneyBalance.text()+",\"JingDouCount\":"+jingDouCount+",\"JingDouRate\":"+jingDouRate+",\"OrderType\":"+order.OrderType.text()+",\"IdCompanyBranch\":"+order.IdCompanyBranch.text()+",\"FactPrice\":"+factPrice+",\"Price\":"+order.Price.text()+",\"SubmitSkuNum\":"+num+",\"UseScore\":"+order.JiFenCount.text()+",\"Flag\":true,\"Message\":null,\"OrderGuid\":\""+order.OrderGuid.text()+"\"," + coupons + "}";

        return result;
    }

}
