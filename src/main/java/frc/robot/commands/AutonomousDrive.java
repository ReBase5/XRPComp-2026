// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

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
        new DriveDistance(0.5, 10, drivetrain),
        new TankTurnDegrees(0.5, 90, drivetrain),
        new DriveDistance(0.5, 10, drivetrain),
        new PushTurnRightDegrees(0.5, 90, drivetrain));
  }
}
