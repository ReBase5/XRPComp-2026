// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDrive extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDrive(XRPDrivetrain drivetrain) {
    addCommands(
      new DriveDistance(2*Constants.SD + Constants.BTD, drivetrain),
      new PushTurnLeft(drivetrain),
      new PushTurnRight(drivetrain),
      new DriveDistance(2*Constants.SD, drivetrain));
  }
}
