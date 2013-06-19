import java.util.HashMap;



public class LineSweep {
	class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	class Line{
		Point left;
		Point right;
		boolean horizontal;
		public Line(Point left, Point right, boolean horizontal){
			this.left = left;
			this.right = right;
			this.horizontal = horizontal;
		}
	}
	
	Line[] lines;
	int count = 0;
	
	public LineSweep(int num){
		lines = new Line[num];
	}
	
	public void horizonatalLine(int x1, int x2, int y){
		Point left = new Point(x1,y);
		Point right = new Point(x2, y);
		lines[count++] = new Line(left, right, true);
	}
	
	public void verticalLine(int x, int y1, int y2){
		Point left = new Point(x,y1);
		Point right = new Point(x, y2);
		lines[count++] = new Line(left, right, false);
	}
	
	public void algorithm(){
		int  i =0;
		BST tree = new BST();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(i<count){
			if(lines[i].horizontal!=true){
				System.out.println(lines[i].left.y+" "+lines[i].right.y);
				tree.range(lines[i].left.y,lines[i].right.y);
			}
			else{
				if(map.get(lines[i].left.y)!=null){
					tree.delete(lines[i].left.y);
					map.put(lines[i].left.y, null);
				}
				else{
					map.put(lines[i].left.y, 1);
					tree.insert(lines[i].left.y);
				}
			}
			i++;
		}
	}
	
	public static void main(String[] arg){
		LineSweep algo= new LineSweep(3);
		algo.horizonatalLine(1, 5, 2);
		algo.verticalLine(3, 1, 8);
		algo.horizonatalLine(4, 7, 5);
		algo.algorithm();
	}
	

}
