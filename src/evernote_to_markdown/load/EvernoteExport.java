package evernote_to_markdown.load;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class EvernoteExport {

	private final Path path;
	private final Document document;

	public EvernoteExport() throws ValidityException, ParsingException, IOException {
		path = Paths.get("notes.enex");
		Builder builder = new Builder();
		document = builder.build(path.toFile());
	}

	public Path getPathToExportFile() {
		return path;
	}

	public Document getDocument() {
		return document;
	}
}
