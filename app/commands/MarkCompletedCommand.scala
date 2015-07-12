package commands

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier

/**
 * Created by gabbi on 12/07/15.
 */
case class MarkCompletedCommand(id:String) {

  @TargetAggregateIdentifier
  def getId:String = id

}
