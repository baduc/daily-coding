package com.bidi.problem;

public class ProblemB {
	public static void main(String[] args) {
		System.out.println(anmoi(9, 2, new int[] { 1000, 1010, 2001, 3000, 4000, 4001, 4002, 4003, 4004 }));
	}

	public static int anmoi(int n, int k, int[] times) {
		if (times.length <= 1)
			return times.length;

		int i = 0;
		int j = 0;
		int server = Integer.MIN_VALUE;
		int process = 0;
		while (i < n && j < n) {
			if (times[i] + 1000 > times[j]) {
				process++;
				j++;
			} else {
				process--;
				i++;
			}

			server = Math.max(server, (int) Math.ceil((double) process / (double) k));
		}
		return server;

	}

	public static int vu(int n, int k, int[] times) {
		int pT = 1000;
		int max = 1;
//		    int[] times = new int[n];
//		    times[0] = io.getInt();
		int windowProcesses = 1;
		int windowStartIndex = 0;

		for (int i = 1; i < n; i++) {
//		      times[i] = io.getInt();
			while (times[windowStartIndex] + pT <= times[i]) {
				windowStartIndex++;
				windowProcesses--;
			}
			windowProcesses++;
			max = Math.max(max, windowProcesses);
		}

		System.out.println((max + k - 1) / k);
		return (max + k - 1) / k;
	}

}
