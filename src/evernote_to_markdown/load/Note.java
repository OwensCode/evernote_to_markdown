package evernote_to_markdown.load;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import nu.xom.Node;
import nu.xom.Nodes;

public class Note {
	private final List<String> tags = new LinkedList<>();
	private final String content;
	private final String title;

	public Note(Nodes title, Nodes content, Nodes tags) {
		super();
		if (title.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.title = extractString(title);
		if (content.isEmpty()) {
			this.content = "";
		} else {
			this.content = extractContent(content);
		}
		for (Node tag : tags) {
			Nodes tagValue = tag.query("./text()");
			if (!tagValue.hasAny()) {
				continue;
			}
			String tagString = extractContent(tagValue);
			this.tags.add(tagString);
		}
	}

	// convert content from HTML to markdown
	private String extractContent(Nodes content) {
		String raw = extractString(content);

		// delete obsolete info from evernote
		int x = (raw.indexOf("evernote.com/pub/enml2.dtd"));
		if (x >= 0) {
			raw = raw.substring(x + 28);
		}

		String converted = raw
				.replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">")
				.replaceFirst("]]>", "")
				.replaceFirst("\n", "")
				.replaceFirst(
						" style=\"word-wrap: break-word; -webkit-nbsp-mode: space; -webkit-line-break: after-white-space;\"",
						"").replaceAll("	", "").replaceFirst("<en-note>", "")
				.replaceFirst("<en-note >", "").replaceAll("<div>", "")
				.replaceAll("</div>", "").replaceAll("</br>", "")
				.replaceAll("<br>", "").replaceAll("<br/>", "")
				.replaceAll("<b>", "**").replaceFirst("</en-note>", "")
				.replaceFirst("\\s*", "").replaceAll("\\&quot\\;", "\\\"")
				.replaceAll("</span>", "").replaceAll("<span([^<]*)>", "")
				.replaceAll("</a>", "").replaceAll("</b>", "**")
				.replaceAll("<u>", "**").replaceAll("</u>", "**")
				.replaceAll("<a([^<]*)>", "").replaceAll("\\*\\*\\*\\*", "")
				.replaceAll("</a>", "").replaceAll("<img([^<]*)>", "")
				.replaceAll("&nbsp;", "").replaceAll("</div>", "")
				.replaceAll("<ul>", "").replaceAll("</ul>", "") 
				.replaceAll("<li>", "").replaceAll("</li>", "") 
				.replaceAll("<ol>", "").replaceAll("</ol>", "");

		return converted;
	}

	private String extractString(Nodes content) {
		return content.get(0).toXML();
	}

	@Override
	public String toString() {
		return getAppendedTags() + "\n" + content + "\n\n";

	}

	public String getAppendedTags() {
		String tagsAppended = "[";
		for (String tag : tags) {
			tagsAppended = tagsAppended + "_" + tag;
		}
		// delete the fist "_" out of the tags string
		tagsAppended = tagsAppended.replace("[_", "[");
		return tagsAppended + "]";
	}

	public Iterable<String> toLines() {
		String[] contentLines = content.split("\n");
		return Arrays.asList(contentLines);
	}

	public String getTitle() {
		return title.replaceAll(":", "..").replaceAll("/", "--")
				.replaceAll(" ", "_").replaceAll("\\\"", "")
				.replaceAll(",", "").replaceAll("_-_", "_")
				.replaceAll("ä", "ae").replaceAll("ö", "oe")
				.replaceAll("ü", "ue").replaceAll("ß", "ss")
				.replaceAll("--", "_").replaceAll("\\?", "")
				.replaceAll("\\(", "_").replaceAll("\\)", "")
				.replaceAll("—", "_").replaceAll("\\.\\.", "")
				.replaceAll("__", "_").replaceAll("___", "_");
	}
}
