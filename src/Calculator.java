import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class Calculator
{
    double rate;
    String fileName = "./eurofxref-daily.xml";

    Calculator() {}

    double calculate(double amountIn, String currency)
    {
        SAXParserFactory Spf = SAXParserFactory.newInstance();
        try
        {
            SAXParser parser = Spf.newSAXParser();
            InputStream inputXML = getClass().getResourceAsStream(fileName);
            CurrencyCalcHandler cch = new CurrencyCalcHandler(currency);
            parser.parse(inputXML, cch);
            rate = cch.getRate();
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }

        return amountIn * rate;
    }
}
