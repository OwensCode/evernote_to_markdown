package evernote_to_markdown.save;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import evernote_to_markdown.load.Note;


public class TagspacesSaver {

	public void save(List<Note> convertedNotes) throws IOException {
		Files.createDirectories(Paths.get("notes_as_markdown"));
		for (Note note : convertedNotes) {
			Path output = Paths.get("notes_as_markdown/"+ note.getTitle() + note.getAppendedTags() + ".md");
			Files.write(output, note.toLines(), Charset.defaultCharset(), StandardOpenOption.CREATE);
		}
	}
}
