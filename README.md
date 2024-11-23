# 更新日志

## 2024/11/21

### 责任链模式

1. **定义接口**

   - **业务作用**：定义责任链模式中的节点接口，规定每个节点需要实现的方法，如处理请求、设置下一个节点等。

   - **代码作用**：通过接口定义，实现了责任链节点的抽象，使得每个节点都可以独立于具体实现而存在。

2. **实现具体的 Handler**

   - **业务作用**：根据业务需求，实现具体的处理器，每个处理器负责处理特定的请求，并决定是否继续传递给下一个处理器。

   - **代码作用**：实现了接口的具体实现类，这些实现类通过接口与业务逻辑解耦，使得每个处理器可以独立开发和测试。

3. **创建 Request 类**

   - **业务作用**：封装请求数据，为责任链提供统一的请求格式，方便各个处理器处理。

   - **代码作用**：定义了请求数据的结构，使得请求的传递和处理更加清晰和规范。

4. **设置责任链**

   - **业务作用**：将处理器按照业务逻辑顺序连接起来，形成一个处理链，每个处理器都有机会处理请求。

   - **代码作用**：通过设置下一个处理器，将处理器按照一定的顺序连接起来，形成一个责任链，实现了请求的顺序传递。

5. **创建 Controller**

   - **业务作用**：通过 Controller 层接收客户端请求，调用 Service 层进行处理。

   - **代码作用**：实现了请求的接收和响应，将业务逻辑与 HTTP 请求解耦，使得业务逻辑更加独立和易于维护。

6. **测试**

   - **业务作用**：通过实际测试，验证责任链模式是否满足业务需求，是否能够正确处理各种请求。

   - **代码作用**：通过实际测试，验证责任链模式的正确性和稳定性，发现并修复潜在的问题。

7. **总结**

   - **业务作用**：责任链模式实现了请求的顺序处理，使得每个处理步骤独立且解耦，方便扩展和维护。

   - **代码作用**：通过责任链模式，实现了代码的模块化和解耦，提高了代码的可读性和可维护性。



## 2024/11/22

### 策略模式+桥接模式

- **流程图分析**：

  - 数据结构定义了订单类型（`orderType`）、支付方式（`paymentMethod`）和订单金额（`amount`）。
- **具体代码讲解**：

  - 代码结合了策略模式和桥接模式，使用Spring Boot构建RESTful API，以处理电商业务的支付和订单流程。

- **设计结构摘要**：

  - 策略模式

    ：

    - `PaymentStrategy`接口定义了支付策略的通用方法。
    - 具体支付策略类（`AlipayPayment`, `CreditCardPayment`, `WeChatPayment`）实现了不同的支付方式。

  - 桥接模式

    ：

    - `OrderProcessor`接口定义了订单处理的通用方法。
    - 具体订单处理类（`OnlineOrderProcessor`, `OfflineOrderProcessor`）根据订单类型进行处理，并与支付策略解耦。

  - **桥接模式应用**：订单处理实现与支付方式实现分离，使得两者可以独立扩展。

- **代码实现摘要**：

  - Maven依赖配置了Spring Boot相关依赖。
  - 支付策略接口和具体实现定义了支付行为。
  - 订单处理接口和具体实现定义了订单处理行为，并通过`setPaymentStrategy`方法与支付策略解耦。
  - `OrderService`服务类使用桥接模式将支付策略注入到订单处理器中，并处理订单。
  - `RequestController`控制器类接收HTTP请求并处理订单请求。

- **测试流程摘要**：

  - 提供了通过Postman或cURL进行RESTful API测试的请求示例，包括创建不同类型和支付方式的订单。

### 观察者模式

1. **接收请求并调用Service层**
   - **Controller层**：接收客户端的请求，调用Service层进行处理。

2. **更新商户状态并通知所有观察者**
   - **Service层**：更新商户状态，并通过`StoreStatusSubject`通知所有观察者。

3. **StoreStatusSubject通知所有观察者**
   - **Subject层**：实现观察者模式的Subject接口，负责添加、删除观察者，并通知所有观察者状态变化。

4. **观察者实现各自逻辑**
   - **Observer层**：实现观察者模式的Observer接口，各个观察者实现各自的逻辑，例如数据统计、系统更新、订单处理等。

5. **设计模式的重要性**

   - **观察者模式**：观察者模式使得系统中的对象之间松耦合，状态变化时，不直接通知各个观察者，而是通过Subject间接通知，这样提高了系统的灵活性和可扩展性。

   - 通过观察者模式，商户状态的变更能够通知到各个系统，而各个系统只需要实现自己的观察者逻辑，无需关心状态变更的细节，这样不仅提高了代码的可读性和可维护性，还使得系统更加灵活，能够方便地添加新的观察者或修改已有的观察者逻辑。



### **命令模式**

1. **流程图分析**：
   - 用户请求通过Controller层进行分发，根据不同的操作（发布笔记、点赞、评论）调用相应的服务和命令，最终返回响应给用户。
2. **代码结构图**：
   - 未提供，但根据代码分析可以推断出结构图包含以下几个部分：Controller层、Command接口、具体的Command实现类、Request和Response的POJO类。
3. **请求Json**：
   - 定义了三个不同的API请求体，分别对应发布笔记、点赞和评论的操作。
4. **代码分析**：
   1.1 **POJO设计**：
    - **评论模块**：`CommentRequest`和`CommentResponse`类分别用于封装评论请求和响应。
    - **点赞模块**：`LikeRequest`和`LikeResponse`类分别用于封装点赞请求和响应。
    - **发帖模块**：`PublishNoteRequest`和`PublishNoteResponse`类分别用于封装发布笔记请求和响应。
      1.2 **Service逻辑**：
    - **抽象接口**：`Command`接口定义了`execute`方法，用于执行具体的命令逻辑。
    - **评论模块**：`CommentCommand`类实现了`Command`接口，执行评论操作。
    - **点赞模块**：`LikeCommand`类实现了`Command`接口，执行点赞操作。
    - **发帖模块**：`PublishNoteCommand`类实现了`Command`接口，执行发布笔记操作。
    - **整合模块**：`CommandService`类整合了不同的命令，提供了执行命令的方法。
      1.3 **Controller**：
    - `NoteController`类作为RESTful API的入口，接收HTTP请求并调用相应的命令服务。
5. **设计模式摘要**：
   - **命令模式**（Command Pattern）：通过将请求封装成对象，允许用户对请求进行参数化、排队或记录，以及支持可撤销的操作。在这个例子中，每个操作（发布笔记、点赞、评论）都被封装成一个命令对象，实现了`Command`接口，并在`CommandService`中被执行。这样的设计使得请求的发送者和接收者解耦，提高了代码的灵活性和可扩展性。

## 2024/11/23

### 模板模式

1. **接收订单请求**：无论是普通订单还是秒杀订单，首先都需要接收来自客户端的订单请求。
2. **验证用户信息**：模板方法流程中的第一步是验证用户信息，这是所有订单处理的共同步骤。
3. **计算订单价格**：接下来，根据订单信息计算订单的总价格，这也是所有订单处理流程中的通用步骤。
4. **创建订单**：在系统中创建订单记录，这一步骤同样适用于所有类型的订单。
5. **特殊处理**：这是模板方法中的一个抽象方法`processorSpecificOrder`，具体实现由子类提供。对于普通订单，可能涉及发货处理；对于秒杀订单，可能需要进行库存检查等特殊流程。

通过模板模式，这些通用步骤被封装在抽象父类`OrderProcessor`中，而特殊步骤则由具体的子类实现，从而避免了代码冗余，并提高了代码的可维护性和可扩展性。
