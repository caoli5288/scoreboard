package com.mengcraft.scoreboard;

import java.util.List;

/**
 * Created on 16-5-18.
 */
public interface LineListBuilder {

    class Impl implements LineListBuilder {

        private final List<Line> handle;

        private Impl(List<Line> handle) {
            this.handle = handle;
        }

        @Override
        public List<Line> build() {
            return null;
        }

        public static LineListBuilder of(List<Line> handle) {
            return new Impl(handle);
        }

    }

    List<Line> build();

}
