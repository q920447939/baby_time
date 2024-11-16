package com.musk.web.handle.future.function;

/**
 * ClassName: Procedure
 *
 * @Description:无参无返回值
 * @date 2022年01月18日
 */
@FunctionalInterface
public interface Procedure {
    void run();

    default Procedure andThen(Procedure after) {
        return () -> {
            this.run();
            after.run();
        };
    }

    default Procedure compose(Procedure before) {
        return () -> {
            before.run();
            this.run();
        };
    }
}
