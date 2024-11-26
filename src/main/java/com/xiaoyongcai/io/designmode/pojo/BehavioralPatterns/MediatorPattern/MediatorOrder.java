        package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.MediatorPattern;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.util.List;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class MediatorOrder {
            private Long id;
            private String customerName;
            private List<String> items;
        }
