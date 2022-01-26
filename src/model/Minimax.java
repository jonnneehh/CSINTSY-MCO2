package model;

public class Minimax {
	public final double MAX = Double.POSITIVE_INFINITY;
	public final double MIN = Double.NEGATIVE_INFINITY;

	public double minimax(int depth, int nodeIndex, Boolean maximizingPlayer, double values[], double alpha,
			double beta) {

		if (values.length <= nodeIndex)
			return values[(int) ((Math.random() * values.length) % values.length)];

		if (depth == 3) {
			return values[nodeIndex];
		}

		if (maximizingPlayer) {
			double best = MIN;
			for (int i = 0; i < 2; i++) {
				double val = minimax(depth + 1, nodeIndex * 2 + i, false, values, alpha, beta);
				best = Math.max(best, val);
				alpha = Math.max(alpha, best);

				if (beta <= alpha)
					break;
			}
			return best;
		} 
		else {
			double best = MAX;
			for (int i = 0; i < 2; i++) {
				double val = minimax(depth + 1, nodeIndex * 2 + i, true, values, alpha, beta);
				best = Math.min(best, val);
				beta = Math.min(beta, best);
				if (beta <= alpha)
					break;
			}
			return best;
		}
	}
}
