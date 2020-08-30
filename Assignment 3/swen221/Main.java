import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import swen221.chessview.*;
import swen221.chessview.moves.Move;
import swen221.chessview.pieces.Bishop;
import swen221.chessview.pieces.Knight;
import swen221.chessview.pieces.Pawn;
import swen221.chessview.pieces.Piece;
import swen221.chessview.pieces.Queen;
import swen221.chessview.pieces.Rook;

public class Main extends JFrame implements ActionListener, KeyListener {
	private static String[] preferredFonts = {"Arial","Times New Roman"};

	private JPanel bottomInnerPanel;
	private JPanel leftInnerPanel;
	private JPanel rightInnerPanel;
	private BoardCanvas boardCanvas;
	private RoundCanvas roundCanvas;

	public Main(ChessGame game) {
		super("Chess View");

		List<Board> boards = game.boards();
		boardCanvas = new BoardCanvas(boards);
		roundCanvas = new RoundCanvas(game.rounds(),boards);

		leftInnerPanel = new JPanel();
		leftInnerPanel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createCompoundBorder(BorderFactory
				.createEmptyBorder(3, 3, 3, 3), BorderFactory
				.createLineBorder(Color.gray));
		leftInnerPanel.setBorder(cb);
		leftInnerPanel.add(boardCanvas, BorderLayout.CENTER);

		rightInnerPanel = new JPanel();
		rightInnerPanel.setLayout(new BorderLayout());
		cb = BorderFactory.createCompoundBorder(BorderFactory
				.createEmptyBorder(3, 3, 3, 3), BorderFactory
				.createLineBorder(Color.gray));
		rightInnerPanel.setBorder(cb);
		rightInnerPanel.add(roundCanvas, BorderLayout.CENTER);

		JButton endbk = new JButton("|<<");
		JButton bkbk = new JButton("<<");
		JButton bk = new JButton("<");
		JButton fdend = new JButton(">>|");
		JButton fdfd = new JButton(">>");
		JButton fd = new JButton(">");

		endbk.addActionListener(this);
		bkbk.addActionListener(this);
		bk.addActionListener(this);
		fdend.addActionListener(this);
		fdfd.addActionListener(this);
		fd.addActionListener(this);

		bottomInnerPanel = new JPanel();
		bottomInnerPanel.add(endbk);
		bottomInnerPanel.add(bkbk);
		bottomInnerPanel.add(bk);
		bottomInnerPanel.add(fd);
		bottomInnerPanel.add(fdfd);
		bottomInnerPanel.add(fdend);

		add(leftInnerPanel,BorderLayout.CENTER);
		add(rightInnerPanel,BorderLayout.EAST);
		add(bottomInnerPanel,BorderLayout.SOUTH);

		setFocusable(true);
		addKeyListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// When a toolbar button or menu item is
		// clicked on this function will be called
		String cmd = e.getActionCommand();
		if (cmd.equals(">")) {
			boardCanvas.fwd(1);
			roundCanvas.fwd(1);
		} else if (cmd.equals(">>")) {
			boardCanvas.fwd(5);
			roundCanvas.fwd(5);
		} else if (cmd.equals(">>|")) {
			boardCanvas.fwd(90000);
			roundCanvas.fwd(90000);
		} else if (cmd.equals("<")) {
			boardCanvas.bwd(1);
			roundCanvas.bwd(1);
		} else if (cmd.equals("<<")) {
			boardCanvas.bwd(5);
			roundCanvas.bwd(5);
		} else if (cmd.equals("|<<")) {
			boardCanvas.bwd(90000);
			roundCanvas.bwd(90000);
		}
	}

	// METHODS REQUIRED FOR KEY LISTENER

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT) {
			boardCanvas.fwd(1);
			roundCanvas.fwd(1);
		} else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT) {
			boardCanvas.bwd(1);
			roundCanvas.bwd(1);
		} else if(code == KeyEvent.VK_UP) {
			boardCanvas.fwd(90000);
			roundCanvas.fwd(90000);
		} else if(code == KeyEvent.VK_DOWN) {
			boardCanvas.bwd(90000);
			roundCanvas.bwd(90000);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@SuppressWarnings("serial")
	private static class BoardCanvas extends Canvas {
		private ArrayList<Board> boards;
		private int index = 0;
		private static final Color BLACK = new Color(90,48,158);
		private static final Color WHITE = new Color(210,205,185);
		private Font font;

		public BoardCanvas(List<Board> boards) {
			this.boards = new ArrayList<>(boards);
			setBounds(0, 0, 400, 400);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			HashSet<String> availableNames = new HashSet();

			for(String name : env.getAvailableFontFamilyNames()) {
				availableNames.add(name);
			}

			for(String pf : preferredFonts) {
				if(availableNames.contains(pf)) {
					font = new Font(pf,Font.PLAIN,20);
					break;
				}
			}
		}

		@Override
		public void paint(Graphics g) {
			int width = (getWidth()-4)/9;
			int height = (getHeight()-4)/9;
			if(font != null) {
				g.setFont(font);
			}
			g.setColor(Color.WHITE);
			g.fillRect(0,0,getWidth(),getHeight());
			drawBackground(g,width+2,2,width,height);
			drawCoords(g,2,2,width,height);
			drawPieces(g,width+2,2,width,height);
		}

		private void drawPieces(Graphics g, int startx, int starty, int width, int height) {
			for(int row=1;row<=8;++row) {
				int ypos = starty + ((8-row)*height);
				for(int col=1;col<=8;++col) {
					int xpos = startx + ((col-1)*width);
					Piece p = boards.get(index).pieceAt(new Position(row,col));
					if(p != null) {
						drawPiece(p,g,xpos,ypos,width,height);
					}
				}
			}
		}

		private void drawPiece(Piece p, Graphics g, int startx, int starty, int width, int height) {
			if(p.isWhite()) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.BLACK);
			}

			width -= 10;
			height -= 10;

			startx += 5;
			starty += 5;
			int endx = startx + width;
			int endy = starty + height;

			if(p instanceof Pawn) {
				int lmidx = startx + width/3;
				int rmidx = endx - (width/3);
				int topy = starty + (height/3);
				int boty = starty + 2*(height/3);
				int[] xpoints = new int[]{lmidx,rmidx,rmidx,endx,startx,lmidx};
				int[] ypoints = new int[]{topy,topy,boty,endy,endy,boty};
				g.fillPolygon(xpoints,ypoints,xpoints.length);
				int lx = startx + width/5;
				int rx = endx - (width/5);
				g.fillOval(lx, starty, rx-lx, height/2);
				g.fillRect(startx, endy-(height/5), width, height/5);
			} else if(p instanceof Knight) {
				int midy = starty + height/3;
				int tmidy = midy - height/4;
				int bmidy = midy + height/4;
				int midx = startx + width/2;
				int lmidx = startx + width/3;
				int llmidx = startx + (3*width)/12;
				int rmidx = endx - (width/3);
				int[] xpoints = new int[]{startx,lmidx,midx,endx,rmidx,lmidx,midx,llmidx};
				int[] ypoints = new int[]{midy,tmidy,starty,tmidy,endy,endy,midy,bmidy};
				g.fillPolygon(xpoints,ypoints,xpoints.length);
				g.fillRect(startx, endy-(height/5), width, height/5);
			} else if(p instanceof Rook) {
				int lmidx = startx + width/6;
				int llmidx = startx + (2*width)/6;
				int rmidx = endx - (width/6);
				int rrmidx = endx - (2*width)/6;
				int topy = starty + (height/5);
				int midy = starty + (height/3);
				int[] xpoints = new int[] { startx, lmidx, lmidx, llmidx, llmidx,
						rrmidx, rrmidx, rmidx, rmidx, endx, endx, rmidx, rmidx, lmidx,
						lmidx, startx };
				int[] ypoints = new int[] { starty, starty, topy, topy, starty,
						starty, topy, topy, starty, starty, midy, midy, endy, endy, midy, midy };
				g.fillPolygon(xpoints,ypoints,xpoints.length);
				g.fillRect(startx, endy-(height/5), width, height/5);
			} else if(p instanceof Bishop) {
				int lx = startx + width/5;
				int rx = endx - (width/5);
				g.fillOval(lx, starty, rx-lx, height);
				g.fillRect(startx, endy-(height/5), width, height/5);
			} else if(p instanceof Queen) {
				int lmidx = startx + width/3;
				int llmidx = startx + width/5;
				int midx = startx + width/2;
				int rmidx = endx - width/3;
				int rrmidx = endx - width/5;
				int topy = starty + (height/2);
				int[] xpoints = new int[] { startx, lmidx,midx,rmidx,endx,rrmidx,llmidx};
				int[] ypoints = new int[] { starty, topy, starty,topy,starty,endy,endy};
				g.fillPolygon(xpoints,ypoints,xpoints.length);
				g.fillRect(startx, endy-(height/5), width, height/5);
			} else {
				int leftx = startx + width/5;
				int midx = startx + width/2;
				int rightx = endx - width/5;
				int topy = starty + height/5;
				int midy = starty + height/2;

				g.fillRect(leftx,topy,rightx-leftx,height/5);
				g.fillRect(midx-(width/10),starty,width/5,2*height/3);
				g.fillOval(leftx, midy, rightx-leftx, endy-midy);
				g.fillRect(startx, endy-(height/5), width, height/5);
			}
		}

		private void drawCoords(Graphics g, int startx, int starty, int width, int height) {
			g.setColor(BLACK);

			FontMetrics metrics = g.getFontMetrics();

			int Aoff = (width - metrics.charWidth('A')) / 2;
			int Boff = (width - metrics.charWidth('B')) / 2;
			int Coff = (width - metrics.charWidth('C')) / 2;
			int Doff = (width - metrics.charWidth('D')) / 2;
			int Eoff = (width - metrics.charWidth('E')) / 2;
			int Foff = (width - metrics.charWidth('F')) / 2;
			int Goff = (width - metrics.charWidth('G')) / 2;
			int Hoff = (width - metrics.charWidth('H')) / 2;
			int Oneoff = (width - metrics.charWidth('1')) / 2;
			int Twooff = (width - metrics.charWidth('2')) / 2;
			int Threeoff = (width - metrics.charWidth('3')) / 2;
			int Fouroff = (width - metrics.charWidth('4')) / 2;
			int Fiveoff = (width - metrics.charWidth('5')) / 2;
			int Sixoff = (width - metrics.charWidth('6')) / 2;
			int Sevenoff = (width - metrics.charWidth('7')) / 2;
			int Eightoff = (width - metrics.charWidth('8')) / 2;

			starty += metrics.getAscent() + (height-metrics.getHeight())/2;

			g.drawChars(new char[]{'1'},0,1,startx+Oneoff,starty+(height*7));
			g.drawChars(new char[]{'2'},0,1,startx+Twooff,starty+(height*6));
			g.drawChars(new char[]{'3'},0,1,startx+Threeoff,starty+(height*5));
			g.drawChars(new char[]{'4'},0,1,startx+Fouroff,starty+(height*4));
			g.drawChars(new char[]{'5'},0,1,startx+Fiveoff,starty+(height*3));
			g.drawChars(new char[]{'6'},0,1,startx+Sixoff,starty+(height*2));
			g.drawChars(new char[]{'7'},0,1,startx+Sevenoff,starty+(height));
			g.drawChars(new char[]{'8'},0,1,startx+Eightoff,starty);

			starty += (height*8);
			g.drawChars(new char[]{'A'},0,1,startx+Aoff+width,starty);
			g.drawChars(new char[]{'B'},0,1,startx+Boff+(width*2),starty);
			g.drawChars(new char[]{'C'},0,1,startx+Coff+(width*3),starty);
			g.drawChars(new char[]{'D'},0,1,startx+Doff+(width*4),starty);
			g.drawChars(new char[]{'E'},0,1,startx+Eoff+(width*5),starty);
			g.drawChars(new char[]{'F'},0,1,startx+Foff+(width*6),starty);
			g.drawChars(new char[]{'G'},0,1,startx+Goff+(width*7),starty);
			g.drawChars(new char[]{'H'},0,1,startx+Hoff+(width*8),starty);
		}

		private void drawBackground(Graphics g, int startx, int starty, int width, int height) {
			int endx = startx + (8*width);
			int endy = starty + (8*height);
			boolean flag = false;
			for(int y=starty;y!=endy;y=y+height) {
				for(int x=startx;x!=endx;x=x+width) {
					flag = !flag;
					if(flag) {
						g.setColor(BLACK);
					} else {
						g.setColor(WHITE);
					}
					g.fillRect(x,y,width,height);
				}
				flag = !flag;
			}
		}

		public void fwd(int amount) {
			index = Math.min(boards.size()-1,index + amount);
			repaint();
		}

		public void bwd(int amount) {
			index = Math.max(0,index - amount);
			repaint();
		}
	}

	private static class RoundCanvas extends Canvas {
		private ArrayList<Round> rounds;
		private ArrayList<Board> boards;
		private int index = 0;
		private static String[] preferredFonts = {"Arial","Times New Roman"};
		private Font font;

		public RoundCanvas(List<Round> rounds, List<Board> boards) {
			this.rounds = new ArrayList<>(rounds);
			this.boards = new ArrayList<>(boards);
			setBounds(0, 0, 200, 400);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			HashSet<String> availableNames = new HashSet();

			for(String name : env.getAvailableFontFamilyNames()) {
				availableNames.add(name);
			}

			for(String pf : preferredFonts) {
				if(availableNames.contains(pf)) {
					font = new Font(pf,Font.PLAIN,20);
					break;
				}
			}
		}

		@Override
		public void paint(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setFont(font);
			FontMetrics metrics = g.getFontMetrics();
			int height = metrics.getHeight();

			int ypos = metrics.getAscent();

			for(int i=0;i!=rounds.size();++i) {
				if((i*2)+1 >= boards.size() || boards.get(i*2) == null) {
					g.setColor(Color.RED);
				} else if((i*2) < index) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.LIGHT_GRAY);
				}
				Move white = rounds.get(i).white();
				char[] chars = white.toString().toCharArray();
				g.drawChars(chars,0,chars.length,10,ypos);
				ypos += height;
			}

			int midx = (getWidth()-20) / 2;
			ypos = metrics.getAscent();

			for(int i=0;i!=rounds.size();++i) {
				if(((i*2)+2) >= boards.size()) {
					g.setColor(Color.RED);
				} else if(((i*2)+1) < index) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.LIGHT_GRAY);
				}
				Move black = rounds.get(i).black();
				if(black != null) {
					char[] chars = black.toString().toCharArray();
					g.drawChars(chars,0,chars.length,midx,ypos);
					ypos += height;
				}
			}
		}


		public void fwd(int amount) {
			index = Math.min(boards.size()-1,index + amount);
			repaint();
		}

		public void bwd(int amount) {
			index = Math.max(0,index - amount);
			repaint();
		}
	}

	public static void main(String[] args) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			File pwd = new File(System.getProperty("user.dir"));
			fileChooser.setCurrentDirectory(pwd);

			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				ChessGame game = new ChessGame(new FileReader(file));
				new Main(game);
			}
		} catch(IOException e) {
			System.err.println("Error loading file!");
			System.err.println(e.getMessage());
		}
	}
}
