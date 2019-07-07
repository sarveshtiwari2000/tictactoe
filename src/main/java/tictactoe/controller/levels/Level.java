package tictactoe.controller.levels;

import tictactoe.controller.levels.SelectLevelHigh;

public enum Level {
	HIGH {
		@Override
		public SelectLevel getInstance() {
			return new SelectLevelHigh();
		}
	};

	public abstract SelectLevel getInstance();
}
