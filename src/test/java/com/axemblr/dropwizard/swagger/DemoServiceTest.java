package com.axemblr.dropwizard.swagger;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoServiceTest {

  private static File configFile;

  @BeforeClass
  public static void setUpClass() throws IOException, InterruptedException {
    configFile = File.createTempFile("dropwizard-swagger", ".yml");
    configFile.deleteOnExit();

    Files.write("name: Test\n".getBytes(Charsets.UTF_8), configFile);

    Thread runner = new Thread() {
      @Override
      public void run() {
        try {
          DemoService.main(new String[]{"server", configFile.getAbsolutePath()});
        } catch (Exception e) {
          throw Throwables.propagate(e);
        }
      }
    };

    runner.setDaemon(true);
    runner.start();

    // TODO replace with wait for port
    TimeUnit.SECONDS.sleep(5);
  }

  private void assertUriExists(String uri) throws IOException {
    HttpClient client = new DefaultHttpClient();
    HttpGet get = new HttpGet("http://localhost:8080" + uri);

    HttpResponse response = client.execute(get);
    assertEquals(200, response.getStatusLine().getStatusCode());
  }

  @Test
  public void testPetResource() throws IOException {
    assertUriExists("/pet.json");
  }

  @Test
  public void testSwaggerUI() throws IOException {
    assertUriExists("/swagger-ui/index.html");
  }

  @Test
  public void testApiDescription() throws IOException {
    assertUriExists("/resources.json");
    assertUriExists("/pet.json/__api/describe");
  }
}
