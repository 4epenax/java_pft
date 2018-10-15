package ru.stqa.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String IpLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("213.221.7.198");
        assertEquals(IpLocation, "<GeoIP><Country>RU</Country><State>48</State></GeoIP>");
    }

    @Test
    public void testInvalidIp() {
        String IpLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("213.221.7.xxx");
        assertEquals(IpLocation, "<GeoIP><Country>RU</Country><State>48</State></GeoIP>");
    }
}
