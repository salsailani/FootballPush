package com.example.footballpush;

import android.content.Context;
import android.widget.TextView;

public class viewNextFixturesParams {
  Context ctx;
  int teamID;
  TextView data;
  public viewNextFixturesParams(Context ctx, int teamID, TextView data){
      this.ctx = ctx;
      this.teamID = teamID;
      this.data = data;
  }
}
