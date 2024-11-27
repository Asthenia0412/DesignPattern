# 食用方式

## 1.项目的部署

- 使用IDEA的Clone功能将该仓库导入你的本地环境
- 或者：你可以选择`git clone https://github.com/Asthenia0412/DesignPattern.git`
- 该项目使用了经典的三层架构：即Controller->Service->Mapper。但为了测试和部署方便，我没有设计具体的Mapper层，而是直接采取日志进行输出。如果你有需要，可以自行在Pojo中设计对应的DO

## 2.项目的测试

- 这里我们以2024/11/24日更新的版本为例：
  - 你可以关注到：SRC下的分包为`Controller` `Service` `Pojo`设计模式的代码都均匀的以`大类名-模式名`存在于上述三个分包内。这里的`大类名`指的是`创建型/结构型/行为型`
  - 你需要在`Controller`层找到你想测试和学习的设计模式的具体Controller,通过访问其暴露的接口进行测试
  - 在测试成功后，你可以在Service和Pojo包下通过与`Controller`包下设计模式名一致的包快速找到该设计模式对应的Service和Pojo代码

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
    - `PaymentStrategy`接口定义了支付策略的通用方法。
    - 具体支付策略类（`AlipayPayment`, `CreditCardPayment`, `WeChatPayment`）实现了不同的支付方式。
  - 桥接模式
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

   A.**POJO设计**：

    - **评论模块**：`CommentRequest`和`CommentResponse`类分别用于封装评论请求和响应。
    - **点赞模块**：`LikeRequest`和`LikeResponse`类分别用于封装点赞请求和响应。
    - **发帖模块**：`PublishNoteRequest`和`PublishNoteResponse`类分别用于封装发布笔记请求和响应。

   B.**Service逻辑**：

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

### 状态模式

- 创建订单：
  - 用户通过发送POST请求到`http://localhost:8080/orders/create`来创建一个新订单。系统将订单状态初始化为"待支付"，并返回订单创建成功的信息。
- 支付订单：
  - 用户通过发送POST请求到`http://localhost:8080/orders/pay/{orderId}`来支付一个订单。系统将订单状态从"待支付"转换为"已支付"，并返回订单支付成功的信息。
- 发货订单：
  - 在订单支付成功后，系统可以通过发送POST请求到`http://localhost:8080/orders/ship/{orderId}`来处理发货操作。订单状态从"已支付"转换为"已发货"，并返回订单发货成功的信息。
- 完成订单：
  - 最后，系统通过发送POST请求到`http://localhost:8080/orders/complete/{orderId}`来完成订单。订单状态变为"已完成"，并返回订单完成的信息。
- 设计模式的作用：
  - 整个业务流程采用了状态模式，它允许订单状态在保持对象结构不变的情况下，根据不同的状态改变行为。
  - 状态模式通过将每个**状态封装成独立的类**，并在上下文（OrderContext）中**管理**这些状态，使得状态转换逻辑更加清晰和灵活。
  - 当订单状态发生变化时，只需要改变**上下文中的状态对象**，而不需要修改上下文本身，从而实现了开闭原则，增强了代码的可维护性和可扩展性。

## 2024/11/24

### 访问者模式

1. **扩展性提升**：通过访问者模式，项目在不修改现有类的情况下，能够轻松添加新的操作，这大大提升了系统的可扩展性，符合软件开发中的开闭原则。
2. **职责分离**：访问者模式实现了行为与对象结构的分离，每个访问者类仅关注对特定对象类型的操作，这不仅简化了类的职责，也提高了代码的可维护性。
3. **集中管理操作**：所有操作被集中管理在访问者类中，避免了策略模式中策略分散的问题，使得操作逻辑更加集中和易于管理。
4. **处理复杂结构**：访问者模式非常适合处理具有复杂结构的对象，如树形结构或对象图，它能够有效地对各个节点进行操作，而不需要修改节点类本身。
5. **业务流程清晰化**：通过业务流程图和代码结构的设计，访问者模式使得商品折扣计算的整个流程变得清晰可见，便于理解和后续的代码维护。
6. 根据上述的策略，使得多品类商品打折问题得到了良好的解决。我们将商品的价格和对价格的操作分离。让操作集中于访问者类中处理。

## 2024/11/26

### 中介者模式

**中间者模式（Mediator Pattern）解决的痛点**

- 中间者模式是一种行为型设计模式，旨在通过引入一个中间者对象来减少各个组件之间的直接交互。
- 传统的系统中，多个对象相互交互时，会导致系统复杂性急剧增加，特别是当系统规模扩大，组件之间的依赖关系逐渐变得错综复杂时，代码的可维护性、可扩展性也会受到影响。此时，中间者模式便显得尤为重要。

**中间者模式的痛点**

1. **高耦合度**：在传统的设计中，每个组件之间往往直接相互依赖。如果有一个组件发生变化，可能会导致其他多个组件的修改，从而使得系统变得脆弱。随着功能的增加，模块之间的依赖关系会迅速复杂化。
2. **难以维护和扩展**：由于组件间的相互调用，某些功能的修改可能需要修改多个地方。随着业务的扩展，维护变得越来越困难。
3. **职责不清**：不同模块之间往往没有明确的分工，导致业务逻辑在多个地方冗余，系统的理解和修改会变得混乱。

**中间者模式如何解决这些痛点**

中间者模式通过引入一个中介者类，所有对象间的交互都通过中介者来协调。这样，每个对象只需要知道如何通过中介者与其他对象交互，而不需要直接与其他对象通信。它的核心思想是**解耦**，降低了对象之间的依赖关系，使得系统更加灵活、易于维护。

- **减少对象之间的依赖**：中介者模式使得对象之间的通信通过一个中心化的中介者进行，避免了多个对象之间相互调用，减少了耦合度。
- **职责分离**：中介者集中处理业务逻辑，避免了重复的逻辑代码分散在多个对象中。
- **提高系统可扩展性**：由于每个对象只与中介者交互，因此添加新的功能或修改现有功能时，只需要修改中介者，而不需要修改多个对象的交互逻辑。

**真实业务场景：电商订单管理**

- 假设我们在构建一个电商平台的订单管理系统。该系统中，订单涉及到多个模块，如库存管理、支付、物流、客户服务等。这些模块需要相互协作来完成订单的处理，而在传统设计中，各个模块之间可能会直接交互，导致耦合度高，维护困难。
- 使用中间者模式后，所有的模块通过一个“订单处理中介者”来协作，避免了直接依赖，提高了系统的可维护性和可扩展性。

**总结对比表**

| **特性**     | **中介者模式**                                 | **观察者模式**                               |
| ------------ | ---------------------------------------------- | -------------------------------------------- |
| **目的**     | 通过引入中介者减少对象间的直接交互，降低耦合度 | 实现一对多的依赖关系，自动通知观察者状态变化 |
| **结构**     | 中介者对象协调多个同事对象的交互               | 主题对象通知多个观察者状态变化               |
| **控制流**   | 中介者处理所有交互逻辑，中心化控制             | 主题状态变化时通知观察者，观察者响应变化     |
| **应用场景** | 复杂交互系统，如订单处理系统、聊天室等         | 一对多事件驱动场景，如UI更新、天气变化通知等 |
| **耦合度**   | 组件通过中介者协作，减少直接依赖               | 主题和观察者之间耦合度较低                   |
| **灵活性**   | 通过修改中介者可以轻松扩展或修改交互逻辑       | 新的观察者可以随时加入，不影响主题对象       |

**选择哪种模式**

- **中介者模式**：适用于系统中有多个组件，需要复杂的交互协调，但又不希望这些组件之间紧密耦合的场景。
- **观察者模式**：适用于**事件驱动**、**一对多通知**的场景，特别是当主题状态变化时需要通知多个观察者并让它们进行更新的场合。

### 享元模式

**一、享元模式的痛点**

享元模式（Flyweight Pattern）主要用来解决在程序中创建大量细粒度对象时所带来的内存和性能问题。在很多场景下，虽然这些对象的状态会有所不同，但大部分共享相同的状态或属性。享元模式通过共享那些可共享的对象，减少内存的占用，提升程序性能。

**常见的痛点**：

- **内存浪费**：在系统中存在大量相似对象时，单独存储每个对象的状态会浪费大量内存。
- **性能瓶颈**：如果每个对象都单独存在，占用大量资源，会导致频繁的垃圾回收和性能下降。
- **不必要的重复对象创建**：例如，大量相似的图片或字体对象，如果每个都单独创建，会浪费很多内存和处理能力。

**二、享元模式的解决方案**

享元模式通过将对象的状态分为**可共享（内部状态）\**和\**不可共享（外部状态）**，将相同的部分共享，减少内存占用。只有当对象的外部状态发生变化时，才创建新的对象。这样一来，多个相似对象就能共享相同的数据，而不是每个对象都占用独立的内存空间。

享元模式的核心思想是：

- **内部状态**：可以共享的部分，不随对象状态变化而变化。
- **外部状态**：随对象不同而不同的部分，通常是方法调用时的参数。

**三、业务场景：商品标签管理系统**

假设我们在一个电商平台（类似互联网大厂的电商系统）中，管理商品的标签。在商品标签的管理中，有很多标签是相似的，例如“热销”，“新品”，“促销”等等，且多个商品可能会有相同的标签。如果为每个商品创建不同的标签对象，将会导致内存消耗过大，性能瓶颈。通过享元模式，我们可以将这些标签对象进行共享，减少内存占用，提高性能。

## 2024/11/27

### 外观模式：

**1. 外观模式的解决痛点**

外观模式的主要目的是通过为子系统中的一组接口提供一个统一的高层接口，从而简化客户端与多个子系统的交互。换句话说，外观模式通过隐藏系统复杂性，提供一个简化的接口，让客户端不必与复杂的子系统进行直接交互。

**痛点分析**：

- 在旅行社的预定系统中，通常涉及多个复杂的服务，例如航班查询、酒店预订、景点门票购买、支付接口等。
- 客户端在与这些服务进行交互时，可能会遇到接口繁杂、系统调用复杂等问题，导致代码冗余，增加了系统的耦合性。
- 使用外观模式可以将这些复杂的子系统封装在一个统一的接口下，简化客户端的调用，降低系统的耦合度。

**2. 旅行社预定系统中的外观模式应用**

假设我们有一个旅行社预定系统，用户可以通过系统进行 **机票预定**、**酒店预定** 和 **景点门票预定** 等服务。每项服务都有各自独立的子系统和接口，我们可以通过外观模式将这些功能集成到一个简单的接口中，供外部调用。
