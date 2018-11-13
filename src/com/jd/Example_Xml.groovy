package com.jd

class Example_Xml {


    private static XmlSlurper parser = new XmlSlurper();

    static void main(String[] args) {
        def order = parser.parseText(getXml());

        def id = order.orderId;

        println("id=============>" + id);

        order.skus.sku.each {
            x -> println("x.Num=============>" + x)
        };
    }

    private static def getXml() {
        def xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<order> \n" +
                "  <orderId>8323232321</orderId>  \n" +
                "  <skus> \n" +
                "    <sku> \n" +
                "      <Num>1</Num> \n" +
                "    </sku>  \n" +
                "    <sku> \n" +
                "      <Num>2</Num> \n" +
                "    </sku>  \n" +
                "    <sku> \n" +
                "      <Num>3</Num> \n" +
                "    </sku> \n" +
                "  </skus> \n" +
                "</order>"
        return xml;
    }

}
