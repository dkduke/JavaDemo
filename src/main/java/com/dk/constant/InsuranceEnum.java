package com.dk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Getter
@AllArgsConstructor
public enum InsuranceEnum {

    //
    INSURANCE_1(1, "保险_1") {
        @Override
        public void settle(Object data) {
            log.info("处理 [{}], data: [{}]", getName(), Objects.toString(data));
        }
    },

    INSURANCE_2(2, "保险_2") {
        @Override
        public void settle(Object data) {
            log.info("处理 [{}], data: [{}]", getName(), Objects.toString(data));
        }
    };

    /**
     * 保险的代码
     */
    private Integer code;

    /**
     * 保险的名字
     */
    private String name;

    /**
     * 结算
     *
     * @param data 数据
     */
    public abstract void settle(Object data);


    private static final Map<Integer, InsuranceEnum> CODE_TO_ENUM;

    static {
        // 构建 code: 枚举实例的对应表，表驱动表现在这里
        CODE_TO_ENUM = Arrays.stream(InsuranceEnum.values())
                .collect(Collectors.toMap(InsuranceEnum::getCode, e -> e));
    }

    /**
     * 根据 code 获取对应的保险
     *
     * @param code code
     * @return code 对应的保险
     */
    public static InsuranceEnum getByCode(Integer code) {

        if (CODE_TO_ENUM.containsKey(code)) {
            return CODE_TO_ENUM.get(code);
        }
        // 想要放心的 throw 运行期异常，就需要全局的异常捕获了
        // 捕获了异常就要有相应的统一返回值
        throw new RuntimeException("没有对应 CODE: [{}] 对应的保险");
    }
}
