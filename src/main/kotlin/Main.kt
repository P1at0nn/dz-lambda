object ChatService {
    val chats = mutableMapOf<Int, Chat>()


//    Возможности для пользователя:
//
// !!! 1)  Видеть, сколько чатов не прочитано (например, service.getUnreadChatsCount). В каждом из таких чатов есть хотя бы одно непрочитанное сообщение.
//  !! 2) Получить список чатов (например, service.getChats).
// !!!3)   Получить список последних сообщений из чатов (можно в виде списка строк). Если сообщений в чате нет (все были удалены), то пишется «нет сообщений».
// !!!4)   Получить список сообщений из чата, указав:
//    ID собеседника;
//    количество сообщений. После того как вызвана эта функция, все отданные сообщения автоматически считаются прочитанными.
//  !!!5)  Создать новое сообщение.
//  6)  Удалить сообщение.
//   7) Создать чат. Чат создаётся, когда пользователю отправляется первое сообщение.
//  !!!!!8)  Удалить чат, т. е. целиком удалить всю переписку.

    fun sendMessages(userId: Int, message: Messages) {   // создать новое сообщение 5) (отправить )

        chats.getOrPut(
            userId,
            { Chat() }).messages += message   // передаем ключ усер ид  и лямду по умолчанию , если  нет усер ид то выполняется лямда  то биш
        //создается чат , а потом илбо у значения по ключу ( чату ) или по новому чату созданному по лямде
        //  затем мы обращаемся к свойству месажес и  добовляем туда месажес
    }


    fun printChat() {
        println(chats)
    }

    fun getUnreadChatCount() = chats.values.count { chat -> chat.messages.any { !it.read } }  //1)
    //пройтись по всем чатам хранящимся в chats, считаем количество элимментов удовлетворяющих лямда выражение  - далее обращаемся к свойству сообщения и ищем не прочитаное


    fun getMessages(userId: Int, count: Int): List<Messages> {        //4)
        val chat = chats[userId] ?: throw ChatNotFoundException()
        return chat.messages.takeLast(count).onEach { it.read = true }
        // takeLast  - возвращаем последнии элементы (count) - на выборке последних элементов  применяем - как пометить прочитаное


    }

    fun getLastMessages(): List<String> {   //3)
        return chats.values.map { it.messages.lastOrNull()?.text ?: "no messages" }
    }


fun delChat(iduser:Int){
     chats.remove(iduser)


        }
    fun getChats(){

        for(chat in chats){
            println("idUser${chat.key} = сообщение в чате ${chat.value}")
        }
    }
    fun delMessage(){
        chats.values.map { it. }
    }

}



    class ChatNotFoundException() : Exception()

    fun main(args: Array<String>) {
ChatService.sendMessages(1, message = Messages(text = "123123", IdMessage = 1))


        ChatService.sendMessages(3, message = Messages(text = "123123", IdMessage = 2))

        ChatService.sendMessages(1, message = Messages(text = "1" , IdMessage = 3))

        ChatService.printChat()
        //ChatService.delChat(3)
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
      //  ChatService.printChat()
ChatService.getChats()
    }



