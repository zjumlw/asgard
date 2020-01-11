package com.will.asgard.common.builderpattern.dialog;

import lombok.Data;

/**
 * Created by WillMao on 19-5-8
 */
@Data
public class MyDialog {
	//警告框标题
	private String title;
	//警告框图标资源Id
	private int iconId;
	//上下文环境
	private Context context;

	@Data
	static class Context {
		private String content;
	}

	public static class Builder {
		private String title = "Title";
		private int iconId = 0;
		private MyDialog.Context context;

		public Builder(MyDialog.Context context) {
			this.context = context;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setIconId(int iconId) {
			this.iconId = iconId;
			return this;
		}

		private void applyConfig(MyDialog myDialog) {
			myDialog.title = title;
			myDialog.iconId = iconId;
			myDialog.context = context;
		}

		public MyDialog build() {
			MyDialog myDialog = new MyDialog();
			applyConfig(myDialog);

			return myDialog;
		}
	}

	public static void main(String[] args) {
		Context context = new Context();
		context.setContent("Nothing");

		MyDialog myDialog = new MyDialog.Builder(context)
				.setTitle("我是标题")
				.setIconId(1)
				.build();

		System.out.println(myDialog);
	}
}
