package cn.sj1.tinyhtml;

import java.util.function.Consumer;

public class HTMLBuilder {
	private final StringBuilder sb;;

	public HTMLBuilder() {
		sb = new StringBuilder();
	}

	public HTMLBuilder(StringBuilder sb) {
		this.sb = sb;
	}

	public StringBuilder getStringBuilder() {
		return sb;
	}

	public final void a(String href, String content) {
		sb.append("<a href=\"").append(href).append("\">");
		sb.append(content);
		sb.append("</a>");
	}

	public final void table(Consumer<HTMLBuilder> content) {
		table_();
		content.accept(this);
		_table();
	}

	public final void table_() {
		sb.append("<table>\n");
	}

	public final void _table() {
		sb.append("</table>\n");
	}

	public final void caption(String content) {
		caption_();
		sb.append(content);
		_caption();
	}

	public final void caption(Consumer<HTMLBuilder> content) {
		caption_();
		content.accept(this);
		_caption();
	}

	public final void caption_() {
		sb.append("<caption>");
	}

	public final void _caption() {
		sb.append("</caption>");
	}

	public final void thead(Consumer<HTMLBuilder> content) {
		thead_();
		content.accept(this);
		_thead();
	}

	public final void thead_() {
		sb.append("<thead>\n");
	}

	public final void _thead() {
		sb.append("</head>");
	}

	public final void tbody(Consumer<HTMLBuilder> content) {
		tbody_();
		content.accept(this);
		_tbody();
	}

	public final void tbody_() {
		sb.append("<tbody>\n");
	}

	public final void _tbody() {
		sb.append("</tbody>\n");
	}

	public final void tr(Consumer<HTMLBuilder> content) {
		tr_();
		content.accept(this);
		_tr();
	}

	public final void tr_() {
		sb.append("<tr>\n");
	}

	public final void _tr() {
		sb.append("</tr>\n");
	}

	public final void th(String clazz, int minWidth, String text) {
		sb.append('<').append("th").append(' ').append("class=\"" + clazz + "\" style=\"min-width:").append(minWidth).append("px;\"max-width:").append(minWidth).append("px;\"").append('>');
		sb.append(text);
		sb.append("</").append("th").append('>');
	}

	public final void th(String clazz, int minWidth, Consumer<HTMLBuilder> content) {
		sb.append('<').append("th").append(' ').append("class=\"" + clazz + "\" style=\"min-width:").append(minWidth).append("px;\"max-width:").append(minWidth).append("px;\"").append('>');
		content.accept(this);
		sb.append("</").append("th").append('>');
	}

	public final void th_(String clazz, int minWidth) {
		sb.append('<').append("th").append(' ').append("class=\"" + clazz + "\" style=\"min-width:").append(minWidth).append("px;\"max-width:").append(minWidth).append("px;\"").append('>');
	}

	public final void _th() {
		sb.append("</").append("th").append('>');
	}

	public final void td(int maxWidth, Object content) {
		td_(maxWidth);
		if (content != null) {
			sb.append(String.valueOf(content));
		} else {
			sb.append("-");
		}
		_td();
	}

	public void td_(int maxWidth) {
		sb.append('<').append("td").append(" style=\"max-width:").append(maxWidth).append("px;\"").append('>');
	}

	public void _td() {
		sb.append("</").append("td").append('>');
	}

	public final void td(Object value) {
		sb.append('<').append("td").append('>');

		if (value != null) {
			sb.append(String.valueOf(value));
		} else {
			sb.append("-");
		}

		_td();
	}

	public final void td(Consumer<HTMLBuilder> content) {
		sb.append('<').append("td").append('>');
		if (content != null) {
			content.accept(this);
		} else {
			sb.append("-");
		}
		_td();
	}

	public final void td(int colspan, int maxWidth, Object value) {
		if (colspan == 1) {
			sb.append('<').append("td").append(" style=\"max-width:").append(maxWidth).append("px;\"").append('>');
		} else {
			sb.append('<').append("td").append(" colspan=\"").append(colspan).append("\"").append(" style=\"max-width:").append(maxWidth).append("px;\"").append('>');
		}

		if (value != null) {
			sb.append(String.valueOf(value));
		} else {
			sb.append("-");
		}

		_td();
	}

	public StringBuilder append(String string) {
		return sb.append(string);
	}

	public StringBuilder append(char c) {
		return sb.append(c);
	}

	public void span(String text) {
		sb.append('<').append("span").append('>');
		sb.append(text);
		sb.append("</").append("span").append('>');
	}

	public void span(String text, String... others) {
		sb.append('<').append("span").append('>');
		sb.append(text);
		for (String string : others) {
			sb.append(string);
		}
		sb.append("</").append("span").append('>');
	}

	public StringBuilder toStandardPage(String title, String footer) {
		StringBuilder sb = new StringBuilder();

		sb.append("<!DOCTYPE html>\n"
				+ "<html lang=\"zh-cn\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"utf-8\" />\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
				+ "</head>\n"
				+ "    <style>"
				+ "        html {\n"
				+ "            box-sizing: border-box;\n"
				+ "        }"
				+ "        *,\n"
				+ "        *:after,\n"
				+ "        *:before {\n"
				+ "            box-sizing: inherit;\n"
				+ "        }        "
				+ "        body {\n"
				+ "            margin: 0;\n"
				+ "            padding: 0;\n"
				// + " font: 18px 'Oxygen', Helvetica;\n"
				+ "            background: #ececec;\n"
				+ "        }"
				+ "        header {\n"
				+ "            height: 60px;\n"
				+ "            background: #512DA8;\n"
				+ "            color: #fff;\n"
				+ "            display: flex;\n"
				+ "            align-items: center;\n"
				+ "            padding: 0 40px;\n"
				+ "            box-shadow: 1px 2px 6px 0px #777;\n"
				+ "        }"
				+ "        h1 {\n"
				+ "            margin: 0;\n"
				+ "        }"
				+ "        .banner {\n"
				+ "            text-decoration: none;\n"
				+ "            color: #fff;\n"
				+ "            cursor: pointer;\n"
				+ "        }"
				+ "        main {\n"
				// + " display: flex;\n"
				+ "            justify-content: center;\n"
				// + " height: calc(100vh - 140px);\n"
				+ "            padding: 20px 40px;\n"
				// + " overflow-y: auto;\n"
				+ "        }"
				+ "\n"
				+ "        footer {\n"
				+ "            height: 40px;\n"
				+ "            background: #2d3850;\n"
				+ "            color: #fff;\n"
				+ "            display: flex;\n"
				+ "            align-items: center;\n"
				+ "            padding: 40px;\n"
				+ "        }"
				+ "    </style>\n");
		sb.append("<title>");

		sb.append(title);

		sb.append("</title>\n");
		sb.append("<body>\n"
				+ "        <!-- Main Application Section -->\n"
				+ "        <header>\n"
				+ "            <h3><a class=\"banner\">");
		sb.append(title);
		sb.append("</a></h3>\n");
		sb.append("        </header>\n");
		
		sb.append("        <main id=\"app\">");

		sb.append(this.sb);

		sb.append("</main>\n"
				+ "        <footer>\n"
				+ "            <span>");
		sb.append(footer);
		sb.append("</span>\n"
				+ "        </footer></body>\n"
				+ "</html>");
		return sb;

	}

}
