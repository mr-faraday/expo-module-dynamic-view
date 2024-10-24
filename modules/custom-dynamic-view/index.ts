import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to CustomDynamicView.web.ts
// and on native platforms to CustomDynamicView.ts
import CustomDynamicViewModule from './src/CustomDynamicViewModule';
import CustomDynamicView from './src/CustomDynamicView';
import { ChangeEventPayload, CustomDynamicViewProps } from './src/CustomDynamicView.types';

// Get the native constant value.
export const PI = CustomDynamicViewModule.PI;

export function hello(): string {
  return CustomDynamicViewModule.hello();
}

export async function setValueAsync(value: string) {
  return await CustomDynamicViewModule.setValueAsync(value);
}

const emitter = new EventEmitter(CustomDynamicViewModule ?? NativeModulesProxy.CustomDynamicView);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { CustomDynamicView, CustomDynamicViewProps, ChangeEventPayload };
