class TodoManager {
    static void main(String[] args) {
        def todoList = []
        def scanner = new Scanner(System.in)
        boolean isRunning = true

        println "📋 Groovy Vazifalar Menejeriga xush kelibsiz!"

        while (isRunning) {
            println "\n--- MENYU ---"
            println "1. Vazifa qo'shish"
            println "2. Ro'yxatni ko'rish"
            println "3. Vazifani o'chirish"
            println "4. Chiqish"
            print "Tanlovingiz: "

            def choice = scanner.nextLine()

            switch (choice) {
                case '1':
                    print "Vazifa matnini kiriting: "
                    def task = scanner.nextLine()
                    todoList << task
                    println "✅ Vazifa qo'shildi!"
                    break
                case '2':
                    println "\nSizning vazifalaringiz:"
                    if (todoList.isEmpty()) println "📭 Ro'yxat bo'sh."
                    else todoList.eachWithIndex { item, index -> println "${index + 1}. $item" }
                    break
                case '3':
                    if (todoList.isEmpty()) {
                        println "❌ O'chirish uchun vazifa yo'q."
                    } else {
                        print "O'chirmoqchi bo'lgan vazifa raqamini kiriting: "
                        int index = scanner.nextLine().toInteger() - 1
                        if (index >= 0 && index < todoList.size()) {
                            def removed = todoList.remove(index)
                            println "🗑 '$removed' muvaffaqiyatli o'chirildi."
                        } else {
                            println "⚠️ Noto'g'ri raqam!"
                        }
                    }
                    break
                case '4':
                    isRunning = false
                    println "👋 Xayr, salomat bo'ling!"
                    break
                default:
                    println "❓ Noto'g'ri buyruq, qaytadan urinib ko'ring."
            }
        }
    }
}