package save;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import fr.umlv.zen5.ApplicationContext;

public class Save {
	public static void gameVsPlayerSave(ApplicationContext  context) throws IOException {
		String name = graphicSave.controller(context);
		if (name.length()==0) {
			context.exit(0);
		}else {

			Path p = Path.of("save/"+name+".txt");
			Charset charset = StandardCharsets.UTF_8;
			try(BufferedWriter writer = Files.newBufferedWriter(p, charset)){				
				StringBuilder s = new StringBuilder();
				s.append("test");
				writer.write(s.toString());
				writer.flush();
			}
		}
	}
}
