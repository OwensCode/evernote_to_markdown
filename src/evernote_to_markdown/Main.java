package evernote_to_markdown;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import evernote_to_markdown.load.EvernoteExport;
import evernote_to_markdown.load.Note;
import evernote_to_markdown.save.TagspacesSaver;

import nu.xom.Document;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class Main {

	public static void main(String[] args) {
		try {
			List<Note> convertedNotes = loadEvernoteNotes();
			print(convertedNotes);
			saveToFile(convertedNotes);
		} catch (ParsingException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void saveToFile(List<Note> convertedNotes) throws IOException {
		new TagspacesSaver().save(convertedNotes);
	}

	private static void print(List<Note> convertedNotes) {
		for (Note note : convertedNotes) {
			System.out.println(note.toString());
		}
	}

	private static List<Note> loadEvernoteNotes() throws ValidityException,
			ParsingException, IOException {
		List<Note> convertedNotes = new LinkedList<>();
		Document document = new EvernoteExport().getDocument();
		Nodes notes = document.getRootElement().query("./child::note");
		for (Node note : notes) {
			Nodes title = note.query("./child::title/text()");
			Nodes tags = note.query("./child::tag");
			Nodes content = note.query("./child::content/text()");
			convertedNotes.add(new Note(title, content, tags));
		}
		return convertedNotes;
	}
}
