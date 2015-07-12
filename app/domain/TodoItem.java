package domain;

import commands.CreateTodoItemCommand;
import commands.MarkCompletedCommand;
import events.definition.TodoItemCompletedEvent;
import events.definition.TodoItemCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by gabbi on 09/07/15.
 */

//TODO: how to handle cases of multiple id requests coming
public class TodoItem extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String id;

    public TodoItem() {
    }

    @CommandHandler
    public TodoItem(CreateTodoItemCommand createTodoItemCommand) {
        System.out.println(toString());
        apply(new TodoItemCreatedEvent(createTodoItemCommand.todoId(), createTodoItemCommand.description()));
    }

    // TODO: understand why this is required
    @EventHandler
    public void on(TodoItemCreatedEvent itemCreatedEvent) {
        this.id = itemCreatedEvent.getTodoId();
        System.out.println("inside event handler 2");
    }

    @CommandHandler
    public void markCompleted(MarkCompletedCommand markCompletedCommand) {
        apply(new TodoItemCompletedEvent(id));
    }
}
