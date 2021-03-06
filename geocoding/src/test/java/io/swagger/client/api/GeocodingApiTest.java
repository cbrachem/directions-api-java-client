/**
 * GraphHopper Geocoding API
 * GraphHopper Geocoding API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.GeocodingResult;
import io.swagger.client.model.Error;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * API tests for GeocodingApi
 */
public class GeocodingApiTest {

    private final GeocodingApi api = new GeocodingApi();

    private final String ghKey = "369dc982-86a6-484e-95ad-669331663ca4";

    @Test
    public void geocodeGetTestMinimal() throws ApiException {
        String key = this.ghKey;
        String q = "Wernau Neckar";
        String locale = null;
        Integer limit = null;
        Boolean reverse = null;
        String point = null;
        String provider = null;
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);
        // Default Limit and Locale
        // TODO: Why is default limit 15? Documentation says it's 10
        // see: https://graphhopper.com/api/1/docs/geocoding/
        assertEquals(15,response.getHits().size());
        assertEquals("en",response.getLocale());

        assertEquals("Wernau (Neckar)",response.getHits().get(0).getName());
        assertEquals(48.68825915,response.getHits().get(0).getPoint().getLat(), .001);
    }

    @Test
    public void geocodeGetTestReverse() throws ApiException {
        String key = this.ghKey;
        String q = null;
        String locale = null;
        Integer limit = null;
        Boolean reverse = true;
        String point = "48.68825915,9.419370517109815";
        String provider = null;
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);

        // Default Limit and Locale
        // TODO: Why is it 5 in this case?
        assertEquals(5,response.getHits().size());
        assertEquals("en",response.getLocale());

        assertEquals("Wernau (Neckar)",response.getHits().get(0).getName());
        assertEquals(48.68825915,response.getHits().get(0).getPoint().getLat(), .001);
    }

    @Test
    public void geocodeGetTestFullParameter() throws ApiException {
        String key = this.ghKey;
        String q = "Wernau Neckar";
        String locale = "de";
        Integer limit = 1;
        Boolean reverse = false;
        String point = "48.68825915,9.419370517109815";
        String provider = "default";
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);

        // Default Limit and Locale
        assertEquals(1,response.getHits().size());
        assertEquals("de",response.getLocale());

        assertEquals("Wernau (Neckar)",response.getHits().get(0).getName());
        assertEquals(48.68825915,response.getHits().get(0).getPoint().getLat(), .001);
    }

    @Test
    public void geocodeGetTestNominatim() throws ApiException {
        String key = this.ghKey;
        String q = "Wernau Neckar";
        String locale = "de";
        Integer limit = 1;
        Boolean reverse = false;
        String point = "48.68825915,9.419370517109815";
        // TODO: With this provider (and opencagedata) we return a copyrights array, but we don't provide one for the default provider
        String provider = "nominatim";
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);

        // Default Limit and Locale
        assertEquals(1,response.getHits().size());
        // TODO Why is locale null here? Maybe we should add it to the geocoding-converter?
        assertEquals(null,response.getLocale());

        assertEquals("Wernau (Neckar), Baden-Württemberg, Deutschland",response.getHits().get(0).getName());
        assertEquals(48.68825915,response.getHits().get(0).getPoint().getLat(), .001);
    }

    @Test(expected = ApiException.class)
    public void geocodeGetTestNoKey() throws ApiException {
        String key = null;
        String q = "Wernau Neckar";
        String locale = null;
        Integer limit = null;
        Boolean reverse = null;
        String point = null;
        String provider = null;
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);
        fail("No excpetion?");
    }

    @Test(expected = ApiException.class)
    public void geocodeGetTestNoQ() throws ApiException {
        String key = this.ghKey;
        String q = null;
        String locale = null;
        Integer limit = null;
        Boolean reverse = null;
        String point = null;
        String provider = null;
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);
        fail("No excpetion?");
    }

    @Test(expected = ApiException.class)
    public void geocodeGetTestNoPointException() throws ApiException {
        String key = this.ghKey;
        String q = null;
        String locale = null;
        Integer limit = null;
        Boolean reverse = true;
        String point = null;
        String provider = null;
        GeocodingResult response = api.geocodeGet(key, q, locale, limit, reverse, point, provider);
        fail("No excpetion?");
    }
    
}
