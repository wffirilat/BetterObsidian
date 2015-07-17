package wffirilat.betterobsidian.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GrowingTree {
	
	public static List<int[]> DIRS = new ArrayList<int[]>();
	public boolean[][][] maze;
	public Random rand;
	public int length;
	public int height;
	public int depth;
	
	static {
		DIRS.add(new int[] {0, 0, 1});
		DIRS.add(new int[] {0, 0, -1});
		DIRS.add(new int[] {0, 1, 0});
		DIRS.add(new int[] {0, -1, 0});
		DIRS.add(new int[] {1, 0, 0});
		DIRS.add(new int[] {-1, 0, 0});
	}
	
	public GrowingTree(int x, int y, int z) {
		this.rand = new Random();
		
		this.length = x;
		this.height = y;
		this.depth = z;
		
		x *= 2; x++;
		y *= 2; y++;
		z *= 2; z++;
		this.maze = new boolean[x][y][z];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < z; k++) {
					if(i == 0 || j == 0 || k == 0 || i == x - 1 || j == y - 1 || k == z - 1) {
						this.maze[i][j][k] = true;
					} else if(i % 2 == 0 || j % 2 == 0 || k % 2 == 0) {
						this.maze[i][j][k] = true;
					}
				}
			}
		}
	}
	
	public void generate() {
		ArrayList<int[]> unvisited = new ArrayList<int[]>();
		for(int x = 0; x < length; x++) {
			for(int y = 0; y < height; y++) {
				for(int z = 0; z < depth; z++) {
					unvisited.add(new int[] {(x * 2) + 1, (y * 2) + 1, (z * 2) + 1});
				}
			}
		}
		
		ArrayList<int[]> working = new ArrayList<int[]>();
		Collections.shuffle(unvisited);
		int[] start = unvisited.get(0);
		unvisited.remove(start);
		working.add(start);
		int counter = 0;
		while(working.size() != 0){
			Collections.shuffle(DIRS);
			int[] current = working.get(pickCell(working.size()));
			boolean found = false;
			for(int[] offset : DIRS) {
				System.out.println("trying offset" + intsToString(offset));
				int[] offsetted = new int[] {(current[0] + offset[0] * 2), 
						(current[1] + offset[1] * 2), 
						(current[2] + offset[2] * 2)};
				int index = getIndexInList(unvisited, offsetted);
				if(index >= 0) {
					int[] wallToRemove = new int[] {(current[0] + offset[0]), 
							(current[1] + offset[1]), 
							(current[2] + offset[2])};
					maze[wallToRemove[0]][wallToRemove[1]][wallToRemove[2]] = false;
					working.add(offsetted);
					counter++;
					unvisited.remove(index);
					found = true;
					System.out.println("valid cell found at " + intsToString(offsetted));
					break;
				}
			}
			if(!found) {
				int index = getIndexInList(working, current);
				working.remove(index);
				System.out.println("no valid cell found, removing current" + intsToString(current));
			}
			if(unvisited.isEmpty()){
				System.out.println("Maze Completed");
				return;
			}
			
		}
		
		
	}
	
	public int pickCell(int length) {
		if(rand.nextInt(4) == 0) {
			return rand.nextInt(length);
		}
		return length - 1;
	}
	
	public static int getIndexInList(final List<int[]> list, final int[] candidate){

		for(int index = 0; index < list.size(); index ++){
		    if(Arrays.equals(list.get(index), candidate)){
		        return index;
		    }
		}
		return -1;
	}
	
	public String intsToString(int[] ints) {
		return "(" + ints[0] + ", " + ints[1] + ", " + ints[2] + ")";
	}

}
