import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CurrencyCalcHandler extends DefaultHandler
{
    double rate;
    String currency;

    CurrencyCalcHandler(String curr)
    {
        currency = curr;
    }

    public double getRate()
    {
        return rate;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        if (attributes.getLength() != 0)
        {
            if (attributes.getQName(0).equals("currency"))
            {
                if (attributes.getValue(0).equals(currency))
                {
                    rate = Double.parseDouble(attributes.getValue(1));
                }
            }
        }

        try
        {
            super.startElement(uri, localName, qName, attributes);
        } catch (SAXException e)
        {
            e.printStackTrace();
        }
    }
}
