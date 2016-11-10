package com.example.yvtc.yvn111001;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by yvtc on 2016/11/10.
 */

public class MyDataHandler extends DefaultHandler {
    boolean inTitle, inItem;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("title"))
        {
            inTitle = true;
        }
        if (qName.equals("item"))
        {
            inItem = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            inTitle = false;
        }
        if (qName.equals("item"))
        {
            inItem = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (inTitle & inItem)
        {
            String str = new String(ch).substring(start, start + length);
            Log.d("NET", str);
        }
    }
}
