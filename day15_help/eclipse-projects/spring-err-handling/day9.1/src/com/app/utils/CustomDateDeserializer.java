package com.app.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer extends StdDeserializer<Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	protected CustomDateDeserializer() {
		super(Date.class);
	}

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		try {
			return sdf.parse(parser.readValueAs(String.class));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
