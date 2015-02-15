package com.sxit.dialog;

import lnpdit.operate.news.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * Create custom Dialog windows for your application Custom dialogs rely on custom layouts wich allow you to create and use your own look & feel.
 * 
 * Under GPL v3 : http://www.gnu.org/licenses/gpl-3.0.html
 * 
 * @author antoine vianey
 * 
 */
public class TipChargeDialog extends Dialog {

	private static boolean vcv = false;

	public TipChargeDialog(Context context, int theme) {
		super(context, theme);

	}

	public TipChargeDialog(Context context) {
		super(context);
	}

	/**
	 * Helper class for creating a custom dialog
	 */
	public static class Builder {

		private Context context;
		private String title;
		// private String message;
		private String positiveButtonText;
		private String negativeButtonText;
		private View contentView;
		private Button goToBvButton;
		private DialogInterface.OnClickListener positiveButtonClickListener, negativeButtonClickListener;

		public Builder(Context context) {
			this.context = context;
		}

		/**
		 * Set the Dialog message from String
		 * 
		 * @param title
		 * @return
		 */
		public Builder setMessage(String message) {
			// this.message = message;
			return this;
		}

		/**
		 * Set the Dialog message from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setMessage(int message) {
			// this.message = (String) context.getText(message);
			return this;
		}

		/**
		 * Set the Dialog title from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}

		/**
		 * Set the Dialog title from String
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		/**
		 * Set a custom content view for the Dialog. If a message is set, the contentView is not added to the Dialog...
		 * 
		 * @param v
		 * @return
		 */
		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(int positiveButtonText, DialogInterface.OnClickListener listener) {
			this.positiveButtonText = (String) context.getText(positiveButtonText);
			this.positiveButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the positive button text and it's listener
		 * 
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener listener) {
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button resource and it's listener
		 * 
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(int negativeButtonText, DialogInterface.OnClickListener listener) {
			this.negativeButtonText = (String) context.getText(negativeButtonText);
			this.negativeButtonClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button text and it's listener
		 * 
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener) {
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		public Builder setVSrt(boolean v) {
			vcv = v;
			return this;

		}

		/**
		 * Create the custom dialog
		 */
		public TipChargeDialog create() {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final TipChargeDialog dialog = new TipChargeDialog(context, R.style.dialog);
			View layout = inflater.inflate(R.layout.insufficient_dialog, null);
			// dialog.addContentView(layout, new LayoutParams(
			// LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			// set the dialog title
			// ((TextView) layout.findViewById(R.id.title)).setText(title);
			// set the confirm button

			((Button) layout.findViewById(R.id.btn1)).setText("鍏呭�");
//			if (positiveButtonClickListener != null) {
				((Button) layout.findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						// positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
//						Intent intent = new Intent();
//						intent.setClass(context, PayDemoActivity.class);
//						context.startActivity(intent);
					}
				});
//			}

			// set the cancel button

			((Button) layout.findViewById(R.id.btn2)).setText("鍙栨秷");
//			if (negativeButtonClickListener != null) {
				((Button) layout.findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						return;
//						negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
					}
				});
//			}

			// set the content message
			// if (message != null) {

			//
			// if (vcv == true) {
			// Button btn = ((Button) layout.findViewById(R.id.positiveButton));
			// btn.setEnabled(true);
			// btn.setBackgroundResource(R.drawable.carloong_button_bg_class2);
			// Button btn1 = ((Button) layout.findViewById(R.id.goToBvButton));
			// btn1.setText(BvedStr);
			// btn1.setEnabled(false);
			// } else {
			// Button btn = ((Button) layout.findViewById(R.id.positiveButton));
			// btn.setEnabled(false);
			// btn.setBackgroundResource(R.drawable.carloong_button_bg_class2_un);
			// Button btn1 = ((Button) layout.findViewById(R.id.goToBvButton));
			// btn1.setText(UnbvStr);
			// btn1.setOnClickListener(new View.OnClickListener() {
			//
			// @Override
			// public void onClick(View v) {
			// dialog.dismiss();
			// Intent intent = new Intent();
			// intent.setClass(context, IdyMainActivity.class);
			// context.startActivity(intent);
			// }
			// });
			// // }

			if (contentView != null) {
				// if no message set
				// add the contentView to the dialog body
				// ((LinearLayout) layout.findViewById(R.id.content))
				// .removeAllViews();
				// ((LinearLayout) layout.findViewById(R.id.content))
				// .addView(contentView,
				// new LayoutParams(
				// LayoutParams.WRAP_CONTENT,
				// LayoutParams.WRAP_CONTENT));
			}
			dialog.setContentView(layout);
			return dialog;
		}
	}

}
