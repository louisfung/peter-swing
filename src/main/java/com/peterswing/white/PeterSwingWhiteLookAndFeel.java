package com.peterswing.white;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.text.DefaultEditorKit;

import sun.swing.SwingLazyValue;
import sun.swing.SwingUtilities2;

public class PeterSwingWhiteLookAndFeel extends BasicLookAndFeel {
	protected static UIDefaults uiDefaults;
	protected static boolean defaultRowBackgroundMode = true;
	protected static boolean showTableGrids = false;
	protected static boolean panelTransparency = true;
	private static boolean bgStipples = true;
	protected static boolean winDecoPanther = false;
	protected static boolean toolbarFlattedButtons = true;
	private static boolean isInstalled = false;
	private String fontName = "Helvetica";

	protected Toolkit awtToolkit = Toolkit.getDefaultToolkit();
	private HashMap<String, String> colorMap = new HashMap<String, String>();

	Object fieldInputMap;

	Object passwordInputMap;
	Object multilineInputMap;

	public PeterSwingWhiteLookAndFeel() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.toLowerCase().contains("mac")) {
			fieldInputMap = new UIDefaults.LazyInputMap(new Object[] { "meta C", DefaultEditorKit.copyAction, "meta V", DefaultEditorKit.pasteAction, "meta X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "meta LEFT", DefaultEditorKit.previousWordAction, "meta KP_LEFT",
					DefaultEditorKit.previousWordAction, "meta RIGHT", DefaultEditorKit.nextWordAction, "meta KP_RIGHT", DefaultEditorKit.nextWordAction, "meta shift LEFT",
					DefaultEditorKit.selectionPreviousWordAction, "meta shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction, "meta shift RIGHT",
					DefaultEditorKit.selectionNextWordAction, "meta shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction, "meta A", DefaultEditorKit.selectAllAction, "HOME",
					DefaultEditorKit.beginLineAction, "END", DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END",
					DefaultEditorKit.selectionEndLineAction, "BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
					"meta H", DefaultEditorKit.deletePrevCharAction, "DELETE", DefaultEditorKit.deleteNextCharAction, "meta DELETE", DefaultEditorKit.deleteNextWordAction,
					"meta BACK_SPACE", DefaultEditorKit.deletePrevWordAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "ENTER", JTextField.notifyAction, "meta BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

			Object passwordInputMap = new UIDefaults.LazyInputMap(new Object[] { "meta C", DefaultEditorKit.copyAction, "meta V", DefaultEditorKit.pasteAction, "meta X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "meta LEFT", DefaultEditorKit.beginLineAction, "meta KP_LEFT", DefaultEditorKit.beginLineAction,
					"meta RIGHT", DefaultEditorKit.endLineAction, "meta KP_RIGHT", DefaultEditorKit.endLineAction, "meta shift LEFT", DefaultEditorKit.selectionBeginLineAction,
					"meta shift KP_LEFT", DefaultEditorKit.selectionBeginLineAction, "meta shift RIGHT", DefaultEditorKit.selectionEndLineAction, "meta shift KP_RIGHT",
					DefaultEditorKit.selectionEndLineAction, "meta A", DefaultEditorKit.selectAllAction, "HOME", DefaultEditorKit.beginLineAction, "END",
					DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END", DefaultEditorKit.selectionEndLineAction, "BACK_SPACE",
					DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "meta H", DefaultEditorKit.deletePrevCharAction, "DELETE",
					DefaultEditorKit.deleteNextCharAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "ENTER", JTextField.notifyAction, "meta BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

			Object multilineInputMap = new UIDefaults.LazyInputMap(new Object[] { "meta C", DefaultEditorKit.copyAction, "meta V", DefaultEditorKit.pasteAction, "meta X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "meta LEFT", DefaultEditorKit.previousWordAction, "meta KP_LEFT",
					DefaultEditorKit.previousWordAction, "meta RIGHT", DefaultEditorKit.nextWordAction, "meta KP_RIGHT", DefaultEditorKit.nextWordAction, "meta shift LEFT",
					DefaultEditorKit.selectionPreviousWordAction, "meta shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction, "meta shift RIGHT",
					DefaultEditorKit.selectionNextWordAction, "meta shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction, "meta A", DefaultEditorKit.selectAllAction, "HOME",
					DefaultEditorKit.beginLineAction, "END", DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END",
					DefaultEditorKit.selectionEndLineAction,

					"UP", DefaultEditorKit.upAction, "KP_UP", DefaultEditorKit.upAction, "DOWN", DefaultEditorKit.downAction, "KP_DOWN", DefaultEditorKit.downAction, "PAGE_UP",
					DefaultEditorKit.pageUpAction, "PAGE_DOWN", DefaultEditorKit.pageDownAction, "shift PAGE_UP", "selection-page-up", "shift PAGE_DOWN", "selection-page-down",
					"meta shift PAGE_UP", "selection-page-left", "meta shift PAGE_DOWN", "selection-page-right", "shift UP", DefaultEditorKit.selectionUpAction, "shift KP_UP",
					DefaultEditorKit.selectionUpAction, "shift DOWN", DefaultEditorKit.selectionDownAction, "shift KP_DOWN", DefaultEditorKit.selectionDownAction, "ENTER",
					DefaultEditorKit.insertBreakAction, "BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "meta H",
					DefaultEditorKit.deletePrevCharAction, "DELETE", DefaultEditorKit.deleteNextCharAction, "meta DELETE", DefaultEditorKit.deleteNextWordAction,
					"meta BACK_SPACE", DefaultEditorKit.deletePrevWordAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "TAB", DefaultEditorKit.insertTabAction, "meta BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "meta HOME", DefaultEditorKit.beginAction, "meta END", DefaultEditorKit.endAction, "meta shift HOME",
					DefaultEditorKit.selectionBeginAction, "meta shift END", DefaultEditorKit.selectionEndAction, "meta T", "next-link-action", "meta shift T",
					"previous-link-action", "meta SPACE", "activate-link-action", "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

		} else {
			fieldInputMap = new UIDefaults.LazyInputMap(new Object[] { "ctrl C", DefaultEditorKit.copyAction, "ctrl V", DefaultEditorKit.pasteAction, "ctrl X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "ctrl LEFT", DefaultEditorKit.previousWordAction, "ctrl KP_LEFT",
					DefaultEditorKit.previousWordAction, "ctrl RIGHT", DefaultEditorKit.nextWordAction, "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction, "ctrl shift LEFT",
					DefaultEditorKit.selectionPreviousWordAction, "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction, "ctrl shift RIGHT",
					DefaultEditorKit.selectionNextWordAction, "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction, "ctrl A", DefaultEditorKit.selectAllAction, "HOME",
					DefaultEditorKit.beginLineAction, "END", DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END",
					DefaultEditorKit.selectionEndLineAction, "BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
					"ctrl H", DefaultEditorKit.deletePrevCharAction, "DELETE", DefaultEditorKit.deleteNextCharAction, "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
					"ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "ENTER", JTextField.notifyAction, "ctrl BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

			passwordInputMap = new UIDefaults.LazyInputMap(new Object[] { "ctrl C", DefaultEditorKit.copyAction, "ctrl V", DefaultEditorKit.pasteAction, "ctrl X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "ctrl LEFT", DefaultEditorKit.beginLineAction, "ctrl KP_LEFT", DefaultEditorKit.beginLineAction,
					"ctrl RIGHT", DefaultEditorKit.endLineAction, "ctrl KP_RIGHT", DefaultEditorKit.endLineAction, "ctrl shift LEFT", DefaultEditorKit.selectionBeginLineAction,
					"ctrl shift KP_LEFT", DefaultEditorKit.selectionBeginLineAction, "ctrl shift RIGHT", DefaultEditorKit.selectionEndLineAction, "ctrl shift KP_RIGHT",
					DefaultEditorKit.selectionEndLineAction, "ctrl A", DefaultEditorKit.selectAllAction, "HOME", DefaultEditorKit.beginLineAction, "END",
					DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END", DefaultEditorKit.selectionEndLineAction, "BACK_SPACE",
					DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "ctrl H", DefaultEditorKit.deletePrevCharAction, "DELETE",
					DefaultEditorKit.deleteNextCharAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "ENTER", JTextField.notifyAction, "ctrl BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

			multilineInputMap = new UIDefaults.LazyInputMap(new Object[] { "ctrl C", DefaultEditorKit.copyAction, "ctrl V", DefaultEditorKit.pasteAction, "ctrl X",
					DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction, "control INSERT",
					DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
					DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
					"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "ctrl LEFT", DefaultEditorKit.previousWordAction, "ctrl KP_LEFT",
					DefaultEditorKit.previousWordAction, "ctrl RIGHT", DefaultEditorKit.nextWordAction, "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction, "ctrl shift LEFT",
					DefaultEditorKit.selectionPreviousWordAction, "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction, "ctrl shift RIGHT",
					DefaultEditorKit.selectionNextWordAction, "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction, "ctrl A", DefaultEditorKit.selectAllAction, "HOME",
					DefaultEditorKit.beginLineAction, "END", DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END",
					DefaultEditorKit.selectionEndLineAction,

					"UP", DefaultEditorKit.upAction, "KP_UP", DefaultEditorKit.upAction, "DOWN", DefaultEditorKit.downAction, "KP_DOWN", DefaultEditorKit.downAction, "PAGE_UP",
					DefaultEditorKit.pageUpAction, "PAGE_DOWN", DefaultEditorKit.pageDownAction, "shift PAGE_UP", "selection-page-up", "shift PAGE_DOWN", "selection-page-down",
					"ctrl shift PAGE_UP", "selection-page-left", "ctrl shift PAGE_DOWN", "selection-page-right", "shift UP", DefaultEditorKit.selectionUpAction, "shift KP_UP",
					DefaultEditorKit.selectionUpAction, "shift DOWN", DefaultEditorKit.selectionDownAction, "shift KP_DOWN", DefaultEditorKit.selectionDownAction, "ENTER",
					DefaultEditorKit.insertBreakAction, "BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "ctrl H",
					DefaultEditorKit.deletePrevCharAction, "DELETE", DefaultEditorKit.deleteNextCharAction, "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
					"ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction, "RIGHT", DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT",
					DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction, "TAB", DefaultEditorKit.insertTabAction, "ctrl BACK_SLASH",
					"unselect"/*DefaultEditorKit.unselectAction*/, "ctrl HOME", DefaultEditorKit.beginAction, "ctrl END", DefaultEditorKit.endAction, "ctrl shift HOME",
					DefaultEditorKit.selectionBeginAction, "ctrl shift END", DefaultEditorKit.selectionEndAction, "ctrl T", "next-link-action", "ctrl shift T",
					"previous-link-action", "ctrl SPACE", "activate-link-action", "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
			});

		}

		if (!isInstalled) {
			isInstalled = true;

			// UIManager.put("ScrollBar.alternateLayout",Boolean.TRUE);
			UIManager.put("FileChooser.fileNameHeaderText", "File");
			UIManager.put("FileChooser.fileSizeHeaderText", "Size");
			UIManager.put("FileChooser.fileTypeHeaderText", "Type");
			UIManager.put("FileChooser.fileDateHeaderText", "Date");
			UIManager.put("FileChooser.fileAttrHeaderText", "Attr");
			UIManager.installLookAndFeel(new UIManager.LookAndFeelInfo("peterswingWhiteLookAndFeel", "com.peterswing.white.peterswingWhiteLookAndFeel"));
		}
	}

	public String getID() {
		return "peterswing_White";
	}

	public String getName() {
		return "Peter-swing white L&F";
	}

	public static ColorUIResource getControl() {
		return (ColorUIResource) uiDefaults.get("control");
	}

	public String getDescription() {
		return "peter-swing white L&F";
	}

	public boolean isNativeLookAndFeel() {
		return false;
	}

	public final boolean isSupportedLookAndFeel() {
		return true;
	}

	public boolean getSupportsWindowDecorations() {
		return true;
	}

	protected void initClassDefaults(UIDefaults table) {
		uiDefaults = table;
		super.initClassDefaults(table);

		table.putDefaults(new Object[] { "PanelUI", "com.peterswing.white.PanelUI", "ButtonUI", "com.peterswing.white.ButtonUI", "ToggleButtonUI",
				"com.peterswing.white.ToggleButtonUI", "TabbedPaneUI", "com.peterswing.white.TabbedPaneUI", "ScrollPaneUI", "com.peterswing.white.ScrollPaneUI", "ScrollBarUI",
				"com.peterswing.white.ScrollBarUI", "TextFieldUI", "com.peterswing.white.TextFieldUI", "PasswordFieldUI", "com.peterswing.white.PasswordFieldUI",
				"FormattedTextFieldUI", "com.peterswing.white.TextFieldUI", "LabelUI", "com.peterswing.white.LabelUI", "CheckBoxUI", "com.peterswing.white.CheckBoxUI",
				"RadioButtonUI", "com.peterswing.white.RadioButtonUI", "ComboBoxUI", "com.peterswing.white.ComboBoxUI", "ToolBarUI", "com.peterswing.white.ToolBarUI",
				"FileChooserUI", "com.peterswing.white.FileChooserUI", "TableUI", "com.peterswing.white.TableUI", "TableHeaderUI", "com.peterswing.white.TableHeaderUI",
				"ProgressBarUI", "com.peterswing.white.ProgressBarUI", "SliderUI", "com.peterswing.white.SliderUI", "SplitPaneUI", "com.peterswing.white.SplitPaneUI", "MenuBarUI",
				"com.peterswing.white.MenuBarUI", "MenuUI", "com.peterswing.white.MenuUI", "ViewportUI", "com.peterswing.white.ViewPortUI", "TreeUI",
				"com.peterswing.white.TreeUI", "SpinnerUI", "com.peterswing.white.PeterSpinnerUI", "ToolTipUI", "com.peterswing.white.PeterToolTipUI" });
	}

	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);

		table.put("Spinner.border", new LineBorder(Color.gray));
		table.put("Spinner.background", Color.white);

		table.put("TextArea.background", Color.white);
		//		table.put("TextArea.border", new LineBorder(Color.gray));
		table.put("TextArea.font", getFont(Font.PLAIN, 12));

		table.put("TextField.focusInputMap", fieldInputMap);
		table.put("PasswordField.focusInputMap", fieldInputMap);

		table.put("TextArea.focusInputMap", multilineInputMap);
		table.put("TextPane.focusInputMap", multilineInputMap);
		table.put("TextPane.background", table.get("text"));
		table.put("TextPane.font", getFont(Font.PLAIN, 12));

		table.put("EditorPane.focusInputMap", multilineInputMap);
		table.put("EditorPane.font", getFont(Font.PLAIN, 12));

		table.put("FormattedTextField.focusInputMap", new UIDefaults.LazyInputMap(new Object[] { "ctrl C", DefaultEditorKit.copyAction, "ctrl V", DefaultEditorKit.pasteAction,
				"ctrl X", DefaultEditorKit.cutAction, "COPY", DefaultEditorKit.copyAction, "PASTE", DefaultEditorKit.pasteAction, "CUT", DefaultEditorKit.cutAction,
				"control INSERT", DefaultEditorKit.copyAction, "shift INSERT", DefaultEditorKit.pasteAction, "shift DELETE", DefaultEditorKit.cutAction, "shift LEFT",
				DefaultEditorKit.selectionBackwardAction, "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction, "shift RIGHT", DefaultEditorKit.selectionForwardAction,
				"shift KP_RIGHT", DefaultEditorKit.selectionForwardAction, "ctrl LEFT", DefaultEditorKit.previousWordAction, "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
				"ctrl RIGHT", DefaultEditorKit.nextWordAction, "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction, "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
				"ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction, "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction, "ctrl shift KP_RIGHT",
				DefaultEditorKit.selectionNextWordAction, "ctrl A", DefaultEditorKit.selectAllAction, "HOME", DefaultEditorKit.beginLineAction, "END",
				DefaultEditorKit.endLineAction, "shift HOME", DefaultEditorKit.selectionBeginLineAction, "shift END", DefaultEditorKit.selectionEndLineAction, "BACK_SPACE",
				DefaultEditorKit.deletePrevCharAction, "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction, "ctrl H", DefaultEditorKit.deletePrevCharAction, "DELETE",
				DefaultEditorKit.deleteNextCharAction, "ctrl DELETE", DefaultEditorKit.deleteNextWordAction, "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction, "RIGHT",
				DefaultEditorKit.forwardAction, "LEFT", DefaultEditorKit.backwardAction, "KP_RIGHT", DefaultEditorKit.forwardAction, "KP_LEFT", DefaultEditorKit.backwardAction,
				"ENTER", JTextField.notifyAction, "ctrl BACK_SLASH", "unselect", "control shift O", "toggle-componentOrientation", "ESCAPE", "reset-field-edit", "UP", "increment",
				"KP_UP", "increment", "DOWN", "decrement", "KP_DOWN", "decrement", }));

		table.put("FileView.directoryIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/dir.png")));
		table.put("FileView.computerIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/drive.png")));
		table.put("FileView.fileIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/file.png")));
		table.put("FileView.floppyDriveIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/floppy.png")));
		table.put("FileView.hardDriveIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/drive.png")));

		table.put("FileChooser.detailsViewIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/vertical.png")));
		table.put("FileChooser.homeFolderIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/home.png")));
		table.put("FileChooser.listViewIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/horizontal.png")));
		table.put("FileChooser.newFolderIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/newDir.png")));
		table.put("FileChooser.upFolderIcon", new ImageIcon(this.getClass().getResource("images/PFileChooser/directoryUp.png")));

		table.put("List.background", Color.white);
		//		table.put("List.border", new LineBorder(Color.gray));
		table.put("List.selectionForeground", table.get("textHighlightText"));
		table.put("List.selectionBackground", table.get("textHighlight"));
		table.put("List.focusCellHighlightBorder", new EmptyBorder(new Insets(0, 0, 0, 0)));
		table.put("List.font", getFont(Font.PLAIN, 12));

		table.put("Panel.background", Color.white);

		table.put("TabbedPane.background", Color.white);
		table.put("TabbedPane.tabAreaBackground", Color.white);
		table.put("TabbedPane.shadow", new Color(169, 209, 255));
		table.put("TabbedPane.darkShadow", Color.white);
		table.put("TabbedPane.highlight", new Color(169, 209, 255));
		table.put("TabbedPane.contentAreaColor", new Color(169, 209, 255));
		table.put("TabbedPane.contentBorderInsets", new Insets(1, 1, 2, 2));

		table.put("SplitPane.border", new LineBorder(Color.white));
		table.put("SplitPane.background", Color.white);

		table.put("Tree.background", Color.white);
		table.put("Tree.selectionBackground", new Color(233, 250, 255));
		table.put("Tree.selectionBorderColor", new Color(154, 154, 154));
		table.put("Tree.expandedIcon", new ImageIcon(this.getClass().getResource("images/JTree/TreeOpen.png")));
		table.put("Tree.collapsedIcon", new ImageIcon(this.getClass().getResource("images/JTree/TreeClosed.png")));
		table.put("Tree.leafIcon", new ImageIcon(this.getClass().getResource("images/JTree/TreeLeaf.png")));
		table.put("Tree.openIcon", new ImageIcon(this.getClass().getResource("images/JTree/TreeOpenIcon.png")));
		table.put("Tree.closedIcon", new ImageIcon(this.getClass().getResource("images/JTree/TreeClosedIcon.png")));
		table.put("Tree.rowHeight", 20);
		// table.put("Tree.expandedIcon", new
		// SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory",
		// "getTreeControlIcon", new Object[] {
		// Boolean.valueOf(MetalIconFactory.DARK) }));
		// table.put("Tree.collapsedIcon", new
		// SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory",
		// "getTreeControlIcon", new Object[]
		// { Boolean.valueOf(MetalIconFactory.LIGHT) }));
		table.put("Tree.line", new DefaultMetalTheme().getPrimaryControl());
		table.put("Tree.hash", new DefaultMetalTheme().getPrimaryControl());

		table.put("Table.background", table.get("text"));
		table.put("Table.foreground", table.get("controlText"));
		table.put("Table.gridColor", new Color(230, 230, 230));
		table.put("Table.selectionBackground", table.get("textHighlight"));
		table.put("Table.selectionForeground", table.get("textHighlightText"));
		table.put("Table.focusCellBackground", table.get("textHighlight"));
		table.put("Table.focusCellForeground", table.get("textHighlightText"));
		table.put("Table.focusCellHighlightBorder", new EmptyBorder(new Insets(1, 1, 1, 1)));
		//		table.put("Table.scrollPaneBorder", new LineBorder(Color.LIGHT_GRAY));
		table.put("Table.scrollPaneBorder", new EmptyBorder(0, 0, 0, 0));
		// table.put("TableHeader.font", getFont(Font.PLAIN, 12));
		table.put("TableHeader.foreground", table.get("textText"));
		table.put("TableHeader.background", table.get("window"));
		table.put("TableHeader.cellBorder", new EmptyBorder(new Insets(1, 1, 1, 1)));

		// table.put("ProgressBar.font", controlTextValue);
		table.put("ProgressBar.foreground", Color.green);
		//		table.put("ProgressBar.background", Color.red);
		table.put("ProgressBar.selectionForeground", Color.black);
		table.put("ProgressBar.selectionBackground", Color.black);
		table.put("ProgressBar.border", new LineBorder(new Color(220, 220, 220)));
		table.put("ProgressBar.cellSpacing", new Integer(0));
		table.put("ProgressBar.cellLength", new Integer(1));

		table.put("OptionPane.background", Color.white);
		table.put("OptionPane.errorIcon", new ImageIcon(this.getClass().getResource("images/JOptionPane/error.png")));
		table.put("OptionPane.informationIcon", new ImageIcon(this.getClass().getResource("images/JOptionPane/information.png")));
		table.put("OptionPane.warningIcon", new ImageIcon(this.getClass().getResource("images/JOptionPane/warning.png")));
		table.put("OptionPane.questionIcon", new ImageIcon(this.getClass().getResource("images/JOptionPane/question.png")));

		// table.put("ToggleButton.select", Color.green);

		table.put("Slider.trackWidth", new Integer(7));
		table.put("Slider.majorTickLength", new Integer(6));

		final Object[] internalFrameIconArgs = new Object[1];
		internalFrameIconArgs[0] = new Integer(16);
		table.put("InternalFrame.icon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/frameIcon.png")));
		// table.put("InternalFrame.border", new SwingLazyValue(
		// "javax.swing.plaf.metal.MetalBorders$InternalFrameBorder"));
		// table.put("InternalFrame.optionDialogBorder", new
		// SwingLazyValue("javax.swing.plaf.metal.MetalBorders$OptionDialogBorder"));
		// table.put("InternalFrame.paletteBorder", new
		// SwingLazyValue("javax.swing.plaf.metal.MetalBorders$PaletteBorder"));
		table.put("InternalFrame.paletteTitleHeight", new Integer(11));
		table.put("InternalFrame.paletteCloseIcon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/close.png")));
		table.put("InternalFrame.closeIcon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/close.png")));
		table.put("InternalFrame.maximizeIcon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/max.png")));
		table.put("InternalFrame.iconifyIcon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/min.png")));
		table.put("InternalFrame.minimizeIcon", new ImageIcon(this.getClass().getResource("images/JInternalFrame/altMax.png")));
		table.put("InternalFrame.titleFont", getFont(Font.PLAIN, 12));
		table.put("InternalFrame.windowBindings", null);
		// Internal Frame Auditory Cue Mappings
		table.put("InternalFrame.closeSound", "sounds/FrameClose.wav");
		table.put("InternalFrame.maximizeSound", "sounds/FrameMaximize.wav");
		table.put("InternalFrame.minimizeSound", "sounds/FrameMinimize.wav");
		table.put("InternalFrame.restoreDownSound", "sounds/FrameRestoreDown.wav");
		table.put("InternalFrame.restoreUpSound", "sounds/FrameRestoreUp.wav");

		// ScrollPane
		table.put("Viewport.background", Color.white);

		// menu
		table.put("MenuBar.background", Color.white);
		table.put("MenuBar.foreground", Color.black);
		table.put("Menu.background", Color.white);
		table.put("Menu.foreground", Color.black);
		table.put("Menu.selectionBackground", new Color(204, 232, 255));
		table.put("Menu.selectionForeground", Color.black);
		table.put("MenuItem.background", Color.white);
		table.put("MenuItem.foreground", Color.black);
		table.put("MenuItem.selectionBackground", new Color(204, 232, 255));
		table.put("MenuItem.selectionForeground", Color.black);
		table.put("CheckBoxMenuItem.background", Color.white);
		table.put("CheckBoxMenuItem.foreground", Color.black);
		table.put("CheckBoxMenuItem.selectionBackground", new Color(204, 232, 255));
		table.put("CheckBoxMenuItem.selectionForeground", Color.black);
		table.put("RadioButtonMenuItem.background", Color.white);
		table.put("RadioButtonMenuItem.foreground", Color.black);
		table.put("RadioButtonMenuItem.selectionBackground", new Color(204, 232, 255));
		table.put("RadioButtonMenuItem.selectionForeground", Color.black);

		// radiobuttonMenu
		table.put("RadioButtonMenuItem.checkIcon", new SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory", "getRadioButtonMenuItemIcon"));
		table.put("RadioButtonMenuItem.arrowIcon", new SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory", "getMenuItemArrowIcon"));

		// popup
		table.put("PopupMenu.border", new LineBorder(Color.LIGHT_GRAY));

		// separator
		table.put("Separator.background", Color.white);
		table.put("Separator.foreground", Color.lightGray);

		table.put("ComboBox.ancestorInputMap", new UIDefaults.LazyInputMap(new Object[] { "ESCAPE", "hidePopup", "PAGE_UP", "pageUpPassThrough", "PAGE_DOWN",
				"pageDownPassThrough", "HOME", "homePassThrough", "END", "endPassThrough", "DOWN", "selectNext", "KP_DOWN", "selectNext", "alt DOWN", "togglePopup", "alt KP_DOWN",
				"togglePopup", "alt UP", "togglePopup", "alt KP_UP", "togglePopup", "SPACE", "spacePopup", "ENTER", "enterPressed", "UP", "selectPrevious", "KP_UP",
				"selectPrevious" }));

		// toolbar
		table.put("ToolBar.rolloverBorder", new LineBorder(Color.gray));
		table.put("ToolBar.nonrolloverBorder", new EmptyBorder(new Insets(1, 1, 1, 1)));

		// Combo Box
		table.put("ComboBox.background", Color.white);
		table.put("ComboBox.foreground", Color.black);
		// table.put("ComboBox.selectionBackground", Color.red);
		// table.put("ComboBox.selectionForeground", Color.blue);

		//		table.put("ScrollPane.border", new EmptyBorder(0, 0, 0, 0));
		//		table.put("ScrollPane.border", new LineBorder(Color.red));
		//		table.put("ScrollPane.viewportBorder", new LineBorder(Color.LIGHT_GRAY));

		// ToolTip
		table.put("ToolTip.font", getFont(Font.PLAIN, 16));
		table.put("ToolTip.foreground", Color.white);
		table.put("ToolTip.border", new EmptyBorder(20, 20, 20, 20));
		table.put("ToolTip.borderInactive", new LineBorder(Color.gray));
		table.put("ToolTip.backgroundInactive", Color.LIGHT_GRAY);
		table.put("ToolTip.foregroundInactive", Color.gray);
		table.put("ToolTip.hideAccelerator", Boolean.FALSE);

		boolean lafCond = SwingUtilities2.isLocalDisplay();
		Object aaTextInfo = SwingUtilities2.AATextInfo.getAATextInfo(lafCond);
		table.put(SwingUtilities2.AA_TEXT_PROPERTY_KEY, aaTextInfo);
	}

	protected void initSystemColorDefaults(UIDefaults table) {
		super.initSystemColorDefaults(table);
		colorMap.put("activeBackground", "#3E91EB");
		colorMap.put("activeBlend", "#3E91EB");
		colorMap.put("activeForeground", "#FFFFFF");
		colorMap.put("activeTitleBtnBg", "#AFD6FF");
		colorMap.put("alternateBackground", "#EEF6FF");
		colorMap.put("background", "#F6F5F4");
		colorMap.put("buttonBackground", "#D7E7F9");
		colorMap.put("buttonForeground", "#000000");
		colorMap.put("foreground", "#000000");
		colorMap.put("inactiveBackground", "#AFD6FF");
		colorMap.put("inactiveBlend", "#AFD6FF");
		colorMap.put("inactiveForeground", "#232323");
		colorMap.put("inactiveTitleBtnBg", "#DAEEFF");
		colorMap.put("linkColor", "#0000C0");
		colorMap.put("selectBackground", "#A9D1FF");
		colorMap.put("selectForeground", "#030303");
		colorMap.put("visitedLinkColor", "#800080");
		colorMap.put("windowBackground", "#FFFFFF");
		colorMap.put("windowForeground", "#000000");

		String[] defaultSystemColors = { "desktop", (String) colorMap.get("alternateBackground"), "activeCaption", (String) colorMap.get("activeBackground"), "activeCaptionText",
				(String) colorMap.get("activeForeground"), "activeCaptionBorder", (String) colorMap.get("activeBackground"), "inactiveCaption",
				(String) colorMap.get("inactiveBackground"), "inactiveCaptionText", (String) colorMap.get("inactiveForeground"), "inactiveCaptionBorder",
				(String) colorMap.get("inactiveBackground"), "window", (String) colorMap.get("background"), "windowBorder", (String) colorMap.get("windowBackground"),
				"windowText", (String) colorMap.get("windowForeground"), "menu", (String) colorMap.get("background"), "menuText", (String) colorMap.get("foreground"), "text",
				(String) colorMap.get("windowBackground"), "textText", (String) colorMap.get("windowForeground"), "textHighlight", (String) colorMap.get("selectBackground"),
				"textHighlightText", (String) colorMap.get("selectForeground"), "textInactiveText", "#A7A5A3", "control", (String) colorMap.get("background"), "controlText",
				(String) colorMap.get("buttonForeground"), "controlHighlight", (String) colorMap.get("buttonBackground"), "controlLtHighlight",
				(String) colorMap.get("selectBackground"), "controlShadow", "#BBBBBB", "controlLightShadow", "#000000", "controlDkShadow", "#000000", "scrollbar", "#000000",
				"info", (String) "#ffffff", "infoText", (String) colorMap.get("foreground") };
		loadSystemColors(table, defaultSystemColors, false);

	}

	protected Font getFont(int type, int size) {
		return new Font(fontName, type, size);
	}

	public static Color getLightControl() {
		return (Color) uiDefaults.get("control");
	}

	public static void setDefaultTableBackgroundMode(boolean b) {
		setDefaultRowBackgroundMode(b);
	}

	public static void setDefaultRowBackgroundMode(boolean b) {
		defaultRowBackgroundMode = b;

		if (!b) {
			showTableGrids = true;
		}
	}

	public static void setuidDecorations(boolean b) {
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(b);
		javax.swing.JDialog.setDefaultLookAndFeelDecorated(b);
	}

	public static void setuidDecorations(boolean b, String type) {
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(b);
		javax.swing.JDialog.setDefaultLookAndFeelDecorated(b);

		if (type.equalsIgnoreCase("panther")) {
			winDecoPanther = true;
		}
	}

	protected static boolean areStipplesUsed() {
		return bgStipples;
	}

	public static void setStipples(boolean b) {
		bgStipples = b;
	}

	public static void setShowTableGrids(boolean showTableGrids) {
		PeterSwingWhiteLookAndFeel.showTableGrids = showTableGrids;
	}

	public static void setPanelTransparency(boolean autoTransparency) {
		PeterSwingWhiteLookAndFeel.panelTransparency = autoTransparency;
	}

	public static void setToolbarFlattedButtons(boolean flatedButtons) {
		PeterSwingWhiteLookAndFeel.toolbarFlattedButtons = flatedButtons;
	}

	public static Color getDesktopColor() {
		return (Color) uiDefaults.get("desktop");
	}

}
